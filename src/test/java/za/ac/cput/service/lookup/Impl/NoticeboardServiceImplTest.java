package za.ac.cput.service.lookup.Impl;

//216266882 Mogamad Tawfeeq Cupido

import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.factory.lookup.NoticeBoardFactory;
import za.ac.cput.repository.lookup.NoticeboardRepository;
import za.ac.cput.service.departement.impl.FlightServiceImpl;
import za.ac.cput.service.lookup.NoticeboardService;

import java.util.List;
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