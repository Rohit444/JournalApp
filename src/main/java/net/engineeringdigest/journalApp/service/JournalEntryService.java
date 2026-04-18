package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

   @Autowired
   private JournalEntryRepository journalEntryRepository;

   @Autowired
   private UserService userService;

   @Transactional // This will tell the spring to treat every operation in this method as single operation.
   public void saveEntry(JournalEntry journalEntry, String userName) {
       try {
           User userNameInDb = userService.findByUserName(userName);
           JournalEntry saved = journalEntryRepository.save(journalEntry);
           userNameInDb.getJournalEntries().add(saved);
           userService.saveEntry(userNameInDb);
       } catch(Exception e){
           log.error("Error occurred ", e);
           throw new RuntimeException("An error occurred while saving the entry ", e);
       }
   }

    public void saveEntry(JournalEntry journalEntry) {
       journalEntryRepository.save(journalEntry);
    }

   public List<JournalEntry> findAll() {
       return journalEntryRepository.findAll();
   }

   public Optional<JournalEntry> findJournalById(ObjectId id) {
       return journalEntryRepository.findById(id);
   }

   @Transactional
   public boolean deleteJournalById(ObjectId id, String userName){
       boolean removed = false;
       try {
           User userNameInDb = userService.findByUserName(userName);
           removed = userNameInDb.getJournalEntries().removeIf(x -> x.getId().equals(id));
           if (removed) {
               userService.saveEntry(userNameInDb);
               journalEntryRepository.deleteById(id);
           }
       } catch(Exception e) {
           log.error("Error occurred ", e);
           throw new RuntimeException("An error occurred while deleting the entry", e);
       }
       return removed;
   };


}
