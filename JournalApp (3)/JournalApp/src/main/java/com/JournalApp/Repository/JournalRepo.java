package com.JournalApp.Repository;

import com.JournalApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepo extends MongoRepository<JournalEntry, ObjectId> {
}
