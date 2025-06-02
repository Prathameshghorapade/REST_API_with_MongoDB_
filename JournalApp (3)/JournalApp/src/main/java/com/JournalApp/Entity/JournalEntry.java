package com.JournalApp.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "Journal_Entries")
@Data
public class JournalEntry {


    @Id
    private String id;

    private String title;

    private String content;

}
