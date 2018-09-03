package com.tony.guestbook.controller;

import com.tony.guestbook.domain.GuestBookEntry;
import com.tony.guestbook.service.GuestBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/comments")
    public List <GuestBookEntry> testMapping () {
        return guestBookService.findAllEntries ();
    }

    @GetMapping ("/comment/{id}")
    public GuestBookEntry findGuestBookEntryById (@PathVariable ("id") Integer id) {
        return this.guestBookService.findGuestBookEntryById (id);
    }

    @GetMapping ("/user/{user}")
    public List <GuestBookEntry> findGuestBookEntriesByUser (@PathVariable ("user") String user) {
        return this.guestBookService.findGuestBookEntriesByUser (user);
    }

    @DeleteMapping ("/comment/{id}")
    public void deleteGuestBookEntryById (@PathVariable ("id") Integer id) {
        this.guestBookService.deleteGuestBookEntryById (id);
    }

}
