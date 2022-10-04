package za.ac.cput.factory.department;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Line;

import static org.junit.jupiter.api.Assertions.*;

class LineFactoryTest {

    @Test
    void buildWithSuccess(){
        Line line =  LineFactory.build("Addis09667","AA13Bus00");
        System.out.println(line);
        assertNotNull(line);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                LineFactory.build(null,"AA13Bus00"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("flightLineId"));
    }
}