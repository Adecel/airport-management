package za.ac.cput.service.lookup.Impl;

import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.factory.lookup.NoticeBoardFactory;
import za.ac.cput.repository.lookup.NoticeboardRepository;
import za.ac.cput.service.lookup.NoticeboardService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NoticeboardServiceImplTest {

    private NoticeBoard noticeBoard;
  @Autowired  private NoticeboardServiceImpl service;



    @BeforeEach
    @Test
    void setUp() {
        this.noticeBoard = NoticeBoardFactory.noticeBoard("AQE252", "Emirates", "02:00", "15:00", "Japan");
        NoticeBoard saved = this.service.save(this.noticeBoard);
        assertEquals(this.noticeBoard, saved);
    }

    @AfterEach
    @Test
    void tearDown() {
        this.service.delete(this.noticeBoard);
        List<NoticeBoard> noticeBoardList = this.service.findAll();
        assertEquals(0, noticeBoardList.size());
    }

    @Test
    void read() {

        Optional<NoticeBoard> read = this.service.read(this.noticeBoard.getFlightID());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(noticeBoard, read.get())

        );
    }

    @Test
    void findAll() {
        List<NoticeBoard> noticeBoardList = this.service.findAll();
        assertEquals(1, noticeBoardList.size());
    }
}