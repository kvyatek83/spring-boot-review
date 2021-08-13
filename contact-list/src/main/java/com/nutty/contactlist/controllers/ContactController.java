package com.nutty.contactlist.controllers;

import com.nutty.schema.api.ContactApi;
import com.nutty.schema.models.Contact;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@NoArgsConstructor
public class ContactController implements ContactApi {
    HashMap<String, Contact> contactList = new HashMap<>();

    @Override
    public ResponseEntity<Void> createContact(@Valid Contact contact) {
        log.info("createContact");
        if (contactList.containsKey(contact.getId())) {
            log.error(String.format("Contact with id: %s already exist", contact.getId()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        contactList.put(contact.getId(), contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Contact> getContact(String contactId) {
        log.info("getContact");

        if (!contactList.containsKey(contactId)) {
            log.error(String.format("Contact with id: %s is not exist", contactId));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contactList.get(contactId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Contact>> getContactList() {
        log.info("getContactList");
        return new ResponseEntity<>(new ArrayList<>(contactList.values()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeContact(String contactId) {
        log.info("removeContact");
        contactList.remove(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateContact(String contactId, @Valid Contact contact) {
        log.info("updateContact");
        contactList.replace(contactId, contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
