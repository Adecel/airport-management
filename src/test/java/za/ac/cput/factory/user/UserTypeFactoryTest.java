package za.ac.cput.factory.user;
/*
  Adecel Rusty Mabiala
  219197229
 */
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.UserType;
import za.ac.cput.factory.user.UserTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserTypeFactoryTest {

    @Test
    @Order(1)
    void buildWithSuccess(){
        UserType userType=  UserTypeFactory.build("user01","010");
        System.out.println(userType);
        assertNotNull(userType);
    }
    @Test
    @Order(2)
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                UserTypeFactory.build(null,"010"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}