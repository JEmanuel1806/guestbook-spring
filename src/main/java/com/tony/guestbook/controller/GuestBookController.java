package com.tony.guestbook.controller;

import com.tony.guestbook.domain.GuestBookEntry;
import com.tony.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/")
    public List <GuestBookEntry> testMapping () {
        return guestBookService.findAllEntries ();
    }
}
