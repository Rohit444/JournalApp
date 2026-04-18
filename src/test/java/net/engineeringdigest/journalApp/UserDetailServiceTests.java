package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import net.engineeringdigest.journalApp.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ActiveProfiles("dev") // This sets and allow this test to only run in dev profile.
public class UserDetailServiceTests {

    // @InjectMocks automatically create the instance of UserDetailsServiceImpl
    // and search for all @Mock annotated dependencies and inject them as well.
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup (){
        // Before running the test initialise all the mocks for this class
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void loadUserByUsername() {
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Rohit").password("sdahudhaibnb").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("Rohit");
//        Assertions.assertNotNull(user);
//
//    }
}
