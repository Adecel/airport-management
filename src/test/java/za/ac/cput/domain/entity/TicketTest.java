package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Test
    public void test(){
        Ticket ticket = new Ticket.Builder()
                .setTicketID("T0111")
                .setDestination("Durban")
                .build();

        Ticket ticket1 = new Ticket.Builder()
                .setTicketID("T0222")
                .build();


        System.out.println(ticket);
        System.out.println(ticket1);


    }

}