package com.nutty.contactlist.controllers;

import com.nutty.schema.api.ContactApi;
import com.nutty.schema.models.Contact;
import lombok.NoArgsConstructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@NoArgsConstructor
public class ContactController implements ContactApi {
    HashMap<String, Contact> contactList = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(ContactController.class);

    @Override
    public ResponseEntity<Void> createContact(@Valid Contact contact) {
        logger();
        if (contactList.containsKey(contact.getId())) {
            logger.error(String.format("Contact with id: %s already exist", contact.getId()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        contactList.put(contact.getId(), contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void logger() {
        logger.info("info createContact");
        logger.error("error createContact");
        logger.debug("debug createContact");
        logger.warn("warn createContact");
        logger.fatal("fatal createContact");
    }

    @Override
    public ResponseEntity<Contact> getContact(String contactId) {
        logger();

        if (!contactList.containsKey(contactId)) {
            logger.error(String.format("Contact with id: %s is not exist", contactId));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contactList.get(contactId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Contact>> getContactList() {
        logger();
        return new ResponseEntity<>(new ArrayList<>(contactList.values()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeContact(String contactId) {
        logger();
        contactList.remove(contactId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateContact(String contactId, @Valid Contact contact) {
        logger();
        contactList.replace(contactId, contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
