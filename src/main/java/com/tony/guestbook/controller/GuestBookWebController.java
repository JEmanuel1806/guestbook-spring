package com.tony.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestBookWebController {

    @GetMapping ("/")
    public String displayGuestBook () {
        return "guestbook";
    }
}
