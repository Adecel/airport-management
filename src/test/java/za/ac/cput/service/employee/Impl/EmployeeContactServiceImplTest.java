package za.ac.cput.service.employee.Impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.factory.employee.EmployeeContactFactory;
import za.ac.cput.factory.passenger.PassengerContactFactory;
import za.ac.cput.service.employee.EmployeeContactService;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
 class EmployeeContactServiceImplTest {

    private EmployeeContact employeeContact;
    @Autowired
    private EmployeeContactServiceImpl service;

/*EmployeeContact employeeContact = EmployeeContactFactory
//        .CreateEmployeeContact("92","test-contact-id");

//@BeforeEach void setUp(){
// a_save
}
*/
    @BeforeEach
    void setUp() {
        this.employeeContact = EmployeeContactFactory.CreateEmployeeContact("72","983737");
        EmployeeContact saved = this.service.save(this.employeeContact);
        assertEquals(this.employeeContact, saved);
    } // setup and save passengerContact

    @AfterEach
    void tearDown() {
        this.service.delete(this.employeeContact);
        List<EmployeeContact> contactList = this.service.findAll();
        assertEquals(0, contactList.size());
    }


//    @Test
//    void a_save() {
//    EmployeeContact saved = service.save(employeeContact);
//    assertNotNull(saved);
//    }

    @Test
    void read() {
        Optional<EmployeeContact> read = service.read("72");
        assertAll(
                ()-> assertNotNull(read),
                ()->assertEquals(this.employeeContact,read)
        );
    }
//
//    @Test
//    void delete() {
//    this.service.delete(employeeContact);
//    }

    @Test
    void findAll() {
        List<EmployeeContact> employeeContactList = this.service.findAll();
        assertEquals(1, employeeContactList.size());
    }
}