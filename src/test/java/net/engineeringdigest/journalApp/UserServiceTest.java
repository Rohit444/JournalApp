package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Disabled
    public void testAdd(){
        assertEquals(4, 2+2);
    }

    @Test
    @Disabled
    public void testFindByUserName(){
        User userName = userRepository.findByUserName("Rohit");
        assertEquals("Rohit", userName.getUserName());
        assertNotNull(userName.getUserName());
    }

    @Test
    @Disabled
    public void testUserJournalEntry() {
        User userName = userRepository.findByUserName("Rohit");
        assertFalse(userName.getJournalEntries().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings ={
            "Rohit",
            "Sam"
    })
    public void testUserNames(String user){
        User userName = userRepository.findByUserName(user);
        assertNotNull(userName);
    }

}
