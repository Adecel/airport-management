package za.ac.cput.factory.contact;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.contact.UserContact;

import static org.junit.jupiter.api.Assertions.*;

class UserContactFactoryTest {

    @Test
    void buildWithSuccess(){
        UserContact userContact =  UserContactFactory.build("user01","WhatsApp",
                "(+27)913633440", "19:25 - 2022/09/30");
        System.out.println(userContact);
        assertNotNull(userContact);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                UserContactFactory.build(null,"rusty@gmail.com",
                        "water", "contact for Employee"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("userId"));
    }
}