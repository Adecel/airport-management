package za.ac.cput.service.passenger.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.factory.lookup.ContactFactory;
import za.ac.cput.factory.passenger.PassengerContactFactory;
import za.ac.cput.service.lookup.Impl.ContactServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PassengerContactServiceImplTest {

    private PassengerContact passengerContact;
    @Autowired
    private PassengersServiceImpl service;

    @BeforeEach
    void setUp() {
        this.passengerContact = PassengerContactFactory.CreatePassengerCont("72","983737");
        PassengerContact saved = this.service.save(this.passengerContact);
        assertEquals(this.passengerContact, saved);
    } // setup and save passengerContact

    @AfterEach
    void tearDown() {
        this.service.delete(this.passengerContact);
        List<PassengerContact> contactList = this.service.findAll();
        assertEquals(0, contactList.size());
    }


    @Test
    void read() {
        Optional<PassengerContact> read = this.service.read(passengerContact.getPassengerId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(passengerContact, read.get())
        );

    }

    @Test
    void findAll() {
        List<PassengerContact> passengerContact = this.service.findAll();
        assertEquals(1, passengerContact.size());

    }
}