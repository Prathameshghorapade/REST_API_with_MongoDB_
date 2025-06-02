package com.JournalApp.Service;

import com.JournalApp.Entity.JournalEntry;
import com.JournalApp.Repository.JournalRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalRepo journalRepo;

    public void saveEntry(JournalEntry journalEntry){

        journalRepo.save(journalEntry);
    }

    public List<JournalEntry> getAllEntry(){

       return journalRepo.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id){

        return journalRepo.findById(id);
    }


    public boolean deleteEntryById(ObjectId id){
        journalRepo.deleteById(id);
        return true;

    }



}
