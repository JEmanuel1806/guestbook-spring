package com.tony.guestbook.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestBookEntryRepository extends CrudRepository <GuestBookEntry, Integer> {

    @Override
    List <GuestBookEntry> findAll ();

    GuestBookEntry findGuestBookEntryById (Integer id);

    List<GuestBookEntry> findGuestBookEntriesByUser (String user);

}
