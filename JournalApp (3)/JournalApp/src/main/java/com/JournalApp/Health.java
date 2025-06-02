package com.JournalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @GetMapping("/helo")
    public  String hello(){
        return "Hello";
    }

}
