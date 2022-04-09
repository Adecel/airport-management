package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.Department;
import za.ac.cput.domain.entity.Employee;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeRepositoryTest {

    private static EmployeeRepository repository = EmployeeRepository.getRepository();
    private static Employee employee = EmployeeFactory.employee("298348657",
            "Sarada Utiwa", "234678", "trolls department");

    @Test
    void a_create() {
        Employee created = repository.create(employee);
        assertEquals(employee.getEmployeeID(), created.getEmployeeID());

        System.out.println("Create : " + created);
    }

    @Test
    void b_read() {
        Employee read = repository.read(employee.getEmployeeID());
        assertNotNull(read);

        System.out.println("Read : " + read);
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee)
                .setEmployeeID("345123098").setEmployeeName("Itachi Utiwa")
                .setDepID("2008734").setDepName("Lagages").build();
        assertNotNull(repository.update(updated));

        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(employee.getEmployeeID());
        assertTrue(success);

        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("View all:");
        System.out.println(repository.getAll());
    }
}