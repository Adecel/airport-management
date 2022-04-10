package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTicketTest {
    @Test
    public void test() {
        PassengerTicket passengerTicket1 = new PassengerTicket.Builder()
                .setPassengerID("P0111")
                .setTicketID("T0111")
                .setPrice(1500)
                .setLuggageID("L0111")
                .build();

        PassengerTicket passengerTicket2 = new PassengerTicket.Builder()
                .setPassengerID("P0222")
                .setTicketID("T0222")
                .build();

        System.out.println(passengerTicket1);
        System.out.println(passengerTicket2);


    }
}