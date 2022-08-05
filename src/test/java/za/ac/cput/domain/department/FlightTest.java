package za.ac.cput.domain.department;

import org.junit.jupiter.api.Test;

class FlightTest {
    @Test
    public void test() {
        Flight flight1 = new Flight.Builder()
                .setFlightID("FAAAA")
                .setDepartureTime("10:00")
                .setArrivalTime("12:00")
                .setCapacity("150")
                .build();

        Flight flight2 = new Flight.Builder()
                .setFlightID("FBBBB")
                .setDepartureTime("10:00")
                .setArrivalTime("12:00")
                .build();

        Flight flight3 = new Flight.Builder()
                .setFlightID("FCCCC")
                .setCapacity("300")
                .build();


        System.out.println( flight1);
        System.out.println(flight2);
        System.out.println(flight3);


    }

}