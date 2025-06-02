package com.JournalApp.Entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "Journal_Entries")
public class JournalEntry {


    @Id
    private ObjectId id;

    private String title;

    private String content;


 private LocalDateTime date;



    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime setDate(LocalDateTime date) {
       return this.date = date;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
