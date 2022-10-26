package za.ac.cput.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.Pilot;
import za.ac.cput.factory.user.PilotFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PilotServiceImplTest {

    @Autowired
    private PilotServiceImpl pilotService;
    private static Pilot pilot_a = PilotFactory.build(17,
            new Name("John","William","Wayne"),
            new Gender("M", "Pilot"),"18:25 - 2022/09/30");


    @Test
    void save() {
        System.out.println("Saved");
        Pilot pilot = pilotService.save(pilot_a);
        assertNotNull(pilot);
    }

    @Test
    void read() {
        Optional<Pilot> read = this.pilotService.read(17);
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals(17, pilot_a.getId())
        );
    }

    @Test
    void delete() {
        System.out.println("deleted");
        this.pilotService.delete(pilot_a);
    }

    @Test
    void deleteById() {
        this.pilotService.deleteById(17);
    }

    @Test
    void findAll() {
        //C

    }
}