
/*GenderRepositoryTest.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.Gender;
import za.ac.cput.factory.GenderFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GenderRepositoryTest {
    private static GenderRepository repository= GenderRepository.getRepository();
    private static Gender gender= GenderFactory.createGender("MALE");
    @Test
    void a_create() {
        Gender created =repository.Create(gender);
        assertEquals(gender.getGenId(),created .getGenId());
        System.out.println("created"+created);
    }

    @Test
    void b_Read() {
        Gender READ =repository.Read(gender.getGenId());
        assertNotNull("read:"+READ);
        System.out.println("read:"+READ);
    }

    @Test
    void c_update() {
        Gender updated= new Gender.Builder().cody(gender).setgenName("Female")
                .Build();
        assertNotNull(repository.Update(updated));
        System.out.println("update"+updated);
    }

    @Test
    void e_delete() {
        boolean success=repository.delete(gender.getGenId());
        assertTrue(success);
        System.out.println("delete:"+success);
    }

    @Test
    void d_getAll() {

        System.out.println(" "+repository.getAll());
    }
}