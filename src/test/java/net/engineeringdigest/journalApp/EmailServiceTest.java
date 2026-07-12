package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @Test
    void testSendmail(){
        emailService.sendEmail("rohitsharmamgs@gmail.com","Test email","This is a test email from spring boot");
    }
}
