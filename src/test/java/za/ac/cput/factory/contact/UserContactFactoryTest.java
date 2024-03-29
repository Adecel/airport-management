package za.ac.cput.factory.contact;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.contact.UserContact;

import static org.junit.jupiter.api.Assertions.*;

class UserContactFactoryTest {

    @Test
    void buildWithSuccess(){
        UserContact userContact =  UserContactFactory.build(1,"19:25 - 2022/09/30"
               );
        System.out.println(userContact);
        assertNotNull(userContact);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                UserContactFactory.build(1,""));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}

