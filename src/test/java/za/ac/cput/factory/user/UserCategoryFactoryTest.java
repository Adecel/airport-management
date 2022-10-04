package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.UserCategory;

import static org.junit.jupiter.api.Assertions.*;

class UserCategoryFactoryTest {

    @Test
    void buildWithSuccess(){
        UserCategory userCategory =  UserCategoryFactory.build("010","Employee",
                "Employee who take care of luggage");
        System.out.println(userCategory);
        assertNotNull(userCategory);
    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                UserCategoryFactory.build(null,"Employee",
                        "Employee who take care of luggage"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}