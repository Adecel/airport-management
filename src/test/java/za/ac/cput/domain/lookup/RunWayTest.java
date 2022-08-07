package za.ac.cput.domain.lookup;

import org.junit.jupiter.api.Test;

//219383448 KISSIMBA NYEMBO ISAAC

class RunWayTest {
    @Test
    public void test(){
        RunWay runWay = new RunWay.Builder().BuildRunwayNumber("3")
                .BuildFlightName("Mango")
                .BuildRunwayStatus("Empty")
                .build();
        System.out.println(runWay);
    }

}