package za.ac.cput.service.departement.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.factory.department.LuggageFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class LuggageServiceImplTest {
    @Autowired
    private LuggageServiceImpl luggageService;
    Luggage luggage = LuggageFactory.build("A-B334", "07586", "Boxes");


    @Test
    void a_save() {
        Luggage temp = luggageService.save(luggage);
        assertNotNull(temp);
    }

    @Test
    void b_read() {
        Optional<Luggage> read = this.luggageService.read("A-B334");
        assertNotNull(read);
        System.out.println(read);
    }


    @Test
    void d_deleteByID() {
this.luggageService.deleteByID("A-B334");

    }

    @Test
    void c_findById() {
        Optional<Luggage> saveEmp = this.luggageService.findById("A-B334");
        assertNotNull(saveEmp);
        System.out.println(saveEmp);
        assertAll(
                () -> assertEquals("A-B334", luggage.getLuggageID())
        );
    }
}