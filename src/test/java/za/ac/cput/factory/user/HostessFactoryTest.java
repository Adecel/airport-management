package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.Hostess;

import static org.junit.jupiter.api.Assertions.*;

class HostessFactoryTest {

    @Test
    void buildWithSuccess(){
        Hostess hostess =  HostessFactory.build("H17","AA13Bus00",
                "user01", "18:25 - 2022/09/30");
        System.out.println(hostess);
        assertNotNull(hostess);
    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                HostessFactory.build(null,"AA13Bus00",
                        "user01", "18:25 - 2022/09/30"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}