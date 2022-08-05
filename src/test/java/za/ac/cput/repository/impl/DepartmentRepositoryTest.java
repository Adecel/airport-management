package za.ac.cput.repository.impl;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.department.DepartmentFactory;
import za.ac.cput.repository.department.DepartmentRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DepartmentRepositoryTest {

    private static DepartmentRepository repository = DepartmentRepository.getRepository();
    private static Department department = DepartmentFactory.department("23423487",
            "trolls department", "transport of lagages");

    @Test
    void a_create() {
        Department created = repository.create(department);
        assertEquals(department.getDepID(), created.getDepID());

        System.out.println("Create : " + created);
    }

    @Test
    void b_read() {
        Department read = repository.read(department.getDepID());
        assertNotNull(read);

        System.out.println("Read : " + read);
    }

    @Test
    void c_update() {
        Department updated = new Department.Builder().copy(department)
                .setDepID("345123098").setDepName("Screens department")
                .setDescription("projections").build();
        assertNotNull(repository.update(updated));

        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(department.getDepID());
        assertTrue(success);

        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("View all:");
        System.out.println(repository.getAll());
    }
}