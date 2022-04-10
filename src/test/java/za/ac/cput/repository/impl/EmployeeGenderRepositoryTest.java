/* EmployeeGenderRepositoryTest.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.EmployeeGender;
import za.ac.cput.factory.EmployeeGenderFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeGenderRepositoryTest {
    private static EmployeeGenderRepository repository= EmployeeGenderRepository.getRepository();
    private static EmployeeGender employeeGender= EmployeeGenderFactory.createEmployeeGender("GRT908743","2HY5q");
    @Test
    void a_create()
    {
        EmployeeGender created =repository.Create(employeeGender);
        assertEquals(employeeGender.getEmployeeId(),created.getEmployeeId());
        System.out.println("created"+created);
    }

    @Test
    void b_read() {
        EmployeeGender READ =repository.Read(employeeGender.getEmployeeId());
        assertNotNull("read:"+READ);
        System.out.println("read:"+READ);
    }

    @Test
    void c_update() {
        EmployeeGender updated= new EmployeeGender.Builder().cody(employeeGender).setgenId("Gts908899")
                .Build();
        assertNotNull(repository.Update(updated));
        System.out.println("update"+updated);
    }

    @Test
    void e_delete() {
        boolean success=repository.delete(employeeGender.getEmployeeId());
        assertTrue(success);
        System.out.println("delete:"+success);
    }

    @Test
    void d_getAll() {
        System.out.println(" "+repository.getAll());
    }
}
