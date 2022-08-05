package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.employee.EmployeeContactFactory;
import za.ac.cput.repository.employee.EmployeeContactRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeContactRepositoryTest {

    private static EmployeeContactRepository repository = EmployeeContactRepository.getRepository();
    private static EmployeeContact employeeContact = EmployeeContactFactory.CreateEmployeeContact("004","0847990440");
    @Test
    void a_create() {
        EmployeeContact created = repository.create(employeeContact);
        assertEquals(employeeContact.getEmployeeId(),created.getEmployeeId());
        System.out.println("Created : " + created);

    }

    @Test
    void b_read() {
        EmployeeContact read = repository.read(employeeContact.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read : "+read);

    }

    @Test
    void c_update() {

        EmployeeContact updated = new EmployeeContact.Builder().copy(employeeContact).setConId("+252615881288")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(employeeContact.getEmployeeId());
        assertTrue(success);
        System.out.println("Deleted : " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all : ");
        System.out.println(repository.getAll());
    }
}