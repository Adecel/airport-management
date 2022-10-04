package za.ac.cput.factory.department;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void buildWithSuccess(){
        Ticket ticket =  TicketFactory.build("T102","user01",
                "Addis09667", "F56",
                "R 1500", "25.00 Kg");
        System.out.println(ticket);
        assertNotNull(ticket);
    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                TicketFactory.build(null,"user01",
                        "Addis09667", "F56",
                        "R 1500", "25.00 Kg"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}