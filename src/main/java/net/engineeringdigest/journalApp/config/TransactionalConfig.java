package net.engineeringdigest.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
// This annotation will tell the spring search those methode which is annotated with @Transactional, and create Transactional context for every method.
// By using this we will achieve atomicity and isolation.
public class TransactionalConfig {

    @Bean
    public PlatformTransactionManager add (MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }
}
// All transaction management is actually done by using an interface PlatformTransactionManager
// and Its implementation class is MongoTransactionManager