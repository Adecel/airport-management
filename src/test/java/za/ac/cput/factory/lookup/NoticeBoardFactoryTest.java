package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.lookup.NoticeBoardFactory;

import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

class NoticeBoardFactoryTest {
    @Test
    public void test(){
        NoticeBoard noticeBoard = NoticeBoardFactory.createNoticeBoard("AR24", "Mango","10:45 PM", "8:30 PM", "JOHANNESBURG");
        System.out.println(noticeBoard.toString());
        assertNotNull(noticeBoard);
    }


}