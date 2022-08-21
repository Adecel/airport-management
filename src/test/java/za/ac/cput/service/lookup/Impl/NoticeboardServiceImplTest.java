package za.ac.cput.service.lookup.Impl;

//Mogamad Tawfeeq Cupido-
//216266882
//21 August 2022

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.factory.lookup.NoticeBoardFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class NoticeboardServiceImplTest {

    @Autowired
    private NoticeboardServiceImpl noticeboardService;
    NoticeBoard noticeBoard = NoticeBoardFactory.noticeBoard("CEZ-2150", "Emirates", "10:50","18:00", "Arizona");

    @Test
    void a_save() {
        NoticeBoard noticeBoard1 = noticeboardService.save(noticeBoard);
        assertNotNull(noticeBoard1);
    }



    @Test
    void b_read() {
        Optional<NoticeBoard> read = this.noticeboardService.read("CEZ-2150");
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_delete() {
        this.noticeboardService.delete(noticeBoard);

    }

    @Test
    void c_findById() {
        Optional<NoticeBoard> noticeBoard2 = this.noticeboardService.findById("CEZ-2150");
        assertNotNull(noticeBoard2);
        System.out.println(noticeBoard2);
        assertAll(
                () -> assertEquals("CEZ-2150", noticeBoard.getFlightID())
        );
    }
}