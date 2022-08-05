package za.ac.cput.domain.lookup;

import org.junit.jupiter.api.Test;

//219383448 KISSIMBA NYEMBO ISAAC

class RunWayTest {
    @Test
    public void test(){
        RunWay runWay = new RunWay.Builder().setRunwayNumber("3")
                .setFlightName("Mango")
                .setRunwayStatus("Empty")
                .build();
        System.out.println(runWay);
    }

}