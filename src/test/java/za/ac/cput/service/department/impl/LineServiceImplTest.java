package za.ac.cput.service.department.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Line;
import za.ac.cput.factory.department.LineFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class LineServiceImplTest {

    @Autowired
    private LineServiceImpl lineService;
    private static Line line_a =
            LineFactory.build("Addis09667","AA13Bus00");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        Line line = lineService.save(line_a);
        assertNotNull(line);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Line> read = this.lineService.read("Addis09667");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("Addis09667", line_a.getFlightLineId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.lineService.delete(line_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.lineService.deleteById("Addis09667");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}