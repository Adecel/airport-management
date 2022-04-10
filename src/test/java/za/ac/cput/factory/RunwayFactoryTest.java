package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.RunWay;

import static org.junit.jupiter.api.Assertions.*;
//219383448 KISSIMBA NYEMBO ISAAC

class RunwayFactoryTest {
    @Test
    public void test(){
        RunWay runWay = RunwayFactory.createRunway("3", "Mango", "Empty");
        System.out.println(runWay.toString());
        assertNotNull(runWay);
    }



}