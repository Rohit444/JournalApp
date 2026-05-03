package net.engineeringdigest.journalApp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication()
@EnableScheduling
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://rohitsharmamgs_db_user:kPKR3q6fZvbOKtjV@cluster0.ywya3qw.mongodb.net/journaldb?retryWrites=true&w=majority");
    }

    @Bean
    public RestTemplate getRestTemplate () {
        return new RestTemplate();
    }
}
