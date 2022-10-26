package za.ac.cput.factory.user;
/*
  Adecel Rusty Mabiala
  219197229
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.factory.user.UserCategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserCategoryFactoryTest {

    @Test
    void buildWithSuccess(){
        UserCategory userCategory =  UserCategoryFactory.build(10,"Employee",
                "Employee who take care of luggage");
        System.out.println(userCategory);
        assertNotNull(userCategory);
    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                UserCategoryFactory.build(0,"Employee",
                        "Employee who take care of luggage"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}