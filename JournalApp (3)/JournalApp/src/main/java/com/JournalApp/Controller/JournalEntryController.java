package com.JournalApp.Controller;

import com.JournalApp.Entity.JournalEntry;
import com.JournalApp.Service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class JournalEntryController {

    @Autowired
 private JournalEntryService journalEntryService;

    @GetMapping("all-entries")
    public ResponseEntity<?>getAllEntries(){

        List<JournalEntry> all=  journalEntryService.getAllEntry();
        if (all != null && !all.isEmpty()){
            return new ResponseEntity<>(all ,HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<?> addEntry(@RequestBody JournalEntry myentry){

       try {
           journalEntryService.saveEntry(myentry);

           return new ResponseEntity<>(myentry,HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(myentry,HttpStatus.BAD_REQUEST);
       }
    }


    @GetMapping("id/{myid}")
    public ResponseEntity<?> getEntryById(@PathVariable ObjectId myid){

       Optional<JournalEntry> entry = journalEntryService.getById(myid);
       if (entry.isPresent()){
           return new ResponseEntity<>(entry.get(), HttpStatus.OK);
       }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId id){
         journalEntryService.deleteEntryById(id);

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


      @PutMapping("id/{id}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){

        JournalEntry old =  journalEntryService.getById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals(" ") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());

            journalEntryService.saveEntry(old);

            return new  ResponseEntity<>(old,HttpStatus.OK);

        }
          return new ResponseEntity<>( HttpStatus.NOT_FOUND);



      }

}
