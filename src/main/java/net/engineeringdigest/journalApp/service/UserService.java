package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

   @Autowired
   private UserRepository userRepository;

   //private final static Logger logger = LoggerFactory.getLogger(UserService.class);

   private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

   public void saveEntry(User user) {
       userRepository.save(user);
   }

    public void saveNewEntry(User user) {
       try {
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user.setRoles(List.of("USER"));
           userRepository.save(user);
       } catch (Exception e){
           log.error("Error occurred for {}", user.getUserName(), e);
           log.warn("Error occurred for ");
           log.info("Error occurred for ");
           log.debug("Error occurred for ");
           log.trace("Error occurred for ");
       }
    }

    public void saveAdminEntry(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER", "ADMIN"));
            userRepository.save(user);
        } catch (Exception e) {
            log.info("Test Logger");
            System.out.println("Error occurred");
        }
    }

   public List<User> findAll() {
       return userRepository.findAll();
   }

   public Optional<User> findJournalById(ObjectId id) {
       return userRepository.findById(id);
   }

   public void deleteJournalById (ObjectId id){
       userRepository.deleteById(id);
   };

   public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
   }


}
