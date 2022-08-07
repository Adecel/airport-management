package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.NoticeBoard;

import static org.junit.jupiter.api.Assertions.*;


//216266882 Mogamad Tawfeeq Cupido

class NoticeBoardFactoryTest {
    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
            NoticeBoardFactory.noticeBoard("", "500", "13:00", "18:00"));

        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("flightID"));
    }

    @Test
    void buildWithSuccess() {
        NoticeBoard noticeBoard= NoticeBoardFactory
                .noticeBoard("test-id","500","13:00","18:00");
        System.out.println(noticeBoard);
        assertAll(
                () -> assertNotNull(noticeBoard),
                () -> assertNotNull(noticeBoard.getFlightID())

        );

    }
}