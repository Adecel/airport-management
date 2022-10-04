package za.ac.cput.factory.contact;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.contact.ContactType;

import static org.junit.jupiter.api.Assertions.*;

class ContactTypeFactoryTest {

     @Test
    void buildWithSuccess(){
        ContactType contactType =  ContactTypeFactory.build("01","rusty@gmail.com",
                "0913633440", "contact for Employee");
        System.out.println(contactType);
        assertNotNull(contactType);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                ContactTypeFactory.build(null,"rusty@gmail.com",
                        "water", "contact for Employee"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}