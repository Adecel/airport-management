package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.RunWay;
import za.ac.cput.factory.lookup.RunwayFactory;
import za.ac.cput.service.lookup.Impl.RunWayServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class RunWayServiceImplTest {
    @Autowired
    private RunWayServiceImpl runWayService;
    RunWay runWay = RunwayFactory.createRunway("RW12", "Lufthanza", "Occupied");

    @Test
    void a_save() {
        RunWay temp = runWayService.save(runWay);
        assertNotNull(temp);
    }

    @Test
    void b_read() {
        Optional<RunWay> read = this.runWayService.read("RW12");
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_deleteByID() {
        this.runWayService.deleteByID("RW12");
    }

    @Test
    void c_findById() {
        Optional<RunWay> saveEmp = this.runWayService.findById("RW12");
        assertNotNull(saveEmp);
        System.out.println(saveEmp);
        assertAll(
                () -> assertEquals("RW12", runWay.getRunwayNumber())
        );
    }
}