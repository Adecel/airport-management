package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.lookup.ContactFactory;

class ContactFactoryTest {


    @Test
    public void test(){
        Contact contact = new ContactFactory().CreateContact("982","084367282","HR");

        System.out.println(contact.toString());
    }

}