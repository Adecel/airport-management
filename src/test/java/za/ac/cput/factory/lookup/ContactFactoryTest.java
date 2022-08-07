package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.factory.lookup.ContactFactory;

class ContactFactoryTest {


    @Test
    public void TestContactFactory(){
        Contact contact = new ContactFactory().CreateContact("982","084367282","HR");

        System.out.println(contact.toString());
    }



}