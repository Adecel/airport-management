package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

class NoticeBoardTest {
    @Test
    public void test(){
        NoticeBoard noticeBoard = new NoticeBoard.Builder().setFlightID("AR24")
                .setFlightName("Mango")
                .setDepartureTime("8:30 PM")
                .setArrivalTime("10:45 PM")
                .setDestination("JOHANNESBURG")
                .build();
        System.out.println(noticeBoard);
    }

}