package net.engineeringdigest.journalApp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true) // with this we would have unique userName
    @NonNull
    private String userName;
    @NonNull
    private String password;

    @DBRef // We are creating a reference of journalEntries in the User table
    private List<JournalEntry> journalEntries = new ArrayList<>();

    private List<String> roles;

}
