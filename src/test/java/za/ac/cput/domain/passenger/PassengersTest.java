package za.ac.cput.domain.passenger;

import org.junit.jupiter.api.Test;

//219383448 KISSIMBA NYEMBO ISAAC

class PassengersTest {
    @Test
    public void test(){
        Passengers passengers = new Passengers.Builder().setPassengerID("219383664")
                .setPassengerFirstName("JONATHAN")
                .setPassengerLastName("KUMINGA")
                .setPassengerAge("20")
                .build();
        System.out.println(passengers);

    }

}