package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {


    @Test
    public void test(){

        Contact contact = new Contact.Builder().setConId("119")
                .setConNumber("064399044")
                .setConDescription("Manager")
                .build();

        Contact contact2 = new Contact.Builder().setConId("119")
                .setConDescription("Manager")
                .build();

        System.out.println(contact);
        System.out.println(contact2);

    }
}