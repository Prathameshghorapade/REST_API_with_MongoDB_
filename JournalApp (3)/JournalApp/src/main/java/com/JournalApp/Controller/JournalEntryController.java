package com.JournalApp.Controller;

import com.JournalApp.Entity.JournalEntry;
import com.JournalApp.Service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class JournalEntryController {

    @Autowired
 private JournalEntryService journalEntryService;

    @GetMapping("all-entries")
    public List<JournalEntry>getAllEntries(){

        return journalEntryService.getAllEntry();
    }


    @PostMapping
    public boolean addEntry(@RequestBody JournalEntry myentry){

        journalEntryService.saveEntry(myentry);

        return true;
    }


    @GetMapping("id/{myid}")
    public JournalEntry getEntryById(@PathVariable ObjectId myid){

       return journalEntryService.getById(myid).orElse(null);
    }

    @DeleteMapping("delete/id/{id}")
    public void deleteEntry(@PathVariable ObjectId id){
         journalEntryService.deleteEntryById(id);

    }


      @PutMapping("id/{id}")
    public JournalEntry updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){

        JournalEntry old =  journalEntryService.getById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals(" ") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }

        journalEntryService.saveEntry(old);

        return old;
    }

}
