package com.tony.guestbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestBookController {

    @GetMapping
    public String testMapping () {
        return "Hello, World";
    }
}
