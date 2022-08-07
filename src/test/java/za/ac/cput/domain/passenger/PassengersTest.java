package za.ac.cput.domain.passenger;

import org.junit.jupiter.api.Test;

//219383448 KISSIMBA NYEMBO ISAAC

class PassengersTest {
    @Test
    public void test(){
        Passengers passengers = new Passengers.Builder().BuildPassengerID("219383664")
                .BuildPassengerFirstName("JONATHAN")
                .BuildPassengerLastName("KUMINGA")
                .BuildPassengerAge("20")
                .build();
        System.out.println(passengers);

    }

}