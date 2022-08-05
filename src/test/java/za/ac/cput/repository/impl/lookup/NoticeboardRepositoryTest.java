package za.ac.cput.repository.impl.lookup;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.lookup.NoticeBoardFactory;
import za.ac.cput.repository.lookup.NoticeboardRepository;
//219383448 KISSIMBA NYEMBO ISAAC

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class NoticeboardRepositoryTest {
    public static NoticeboardRepository repository =NoticeboardRepository.getRepository();
    public static NoticeBoard noticeBoard = NoticeBoardFactory.createNoticeBoard("AR24","MANGO", "9:45 PM", "8:30 PM", "JOHANNESBURG");


    @Test
    void a_create() {
        NoticeBoard created = repository.create(noticeBoard);
        assertEquals(noticeBoard.getFlightID(), created.getFlightID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        NoticeBoard read = repository.read(noticeBoard.getFlightID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        NoticeBoard updated = new NoticeBoard.Builder().copy(noticeBoard).setFlightID("AB89")
                .setFlightName("FlySaFair")
                .setDepartureTime("6:45 PM")
                .setArrivalTime("9:30 PM")
                .setDestination("Durban")
                .build();
        assertNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(noticeBoard.getFlightID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }

}