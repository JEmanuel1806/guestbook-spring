package com.tony.guestbook.controller;

import com.tony.guestbook.domain.GuestBookEntry;
import com.tony.guestbook.service.GuestBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestBookWebController {

    @Autowired
    private GuestBookService guestBookService;

    private static final String ENTRIES_TEMPLATE_ID = "entries";
    private static final String NEW_ENTRY_TEMPLATE_ID = "newEntry";

    private static final String GUESTBOOK_TEMPLATE = "guestbook";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";

    @GetMapping ("/")
    public String displayGuestBook (Model model) {

        model.addAttribute (ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries ());
        model.addAttribute (NEW_ENTRY_TEMPLATE_ID, new GuestBookEntry ());

        return GUESTBOOK_TEMPLATE;
    }

    @GetMapping ("/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {
        this.guestBookService.deleteGuestBookEntryById (id);

        return HOMEPAGE_REDIRECT;
    }

    @PostMapping("/")
    public String addComment (@ModelAttribute (NEW_ENTRY_TEMPLATE_ID) GuestBookEntry newEntry) {

        this.guestBookService.save (newEntry);

        return HOMEPAGE_REDIRECT;
    }

}
