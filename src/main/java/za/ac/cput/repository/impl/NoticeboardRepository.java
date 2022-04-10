package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.entity.NoticeBoard;

import java.util.HashSet;
import java.util.Set;

public class NoticeboardRepository implements NRepository {

    public static NoticeboardRepository repository = null;
    private Set<NoticeBoard> noticeDB = null;
    private NoticeboardRepository() {
        noticeDB = new HashSet<NoticeBoard>();
    }

    public static NoticeboardRepository getRepository(){
        if (repository == null) {
            repository = new NoticeboardRepository();
        }
        return repository;
    }



    @Override
    public NoticeBoard create(NoticeBoard noticeBoard) {
        boolean success = noticeDB.add(noticeBoard) ;
        if(!success)
            return null;
        return noticeBoard;
    }

    @Override
    public NoticeBoard read(String FlightID) {
        NoticeBoard noticeBoard= noticeDB.stream()
                .filter(e -> e.getFlightID().equals(FlightID))
                .findAny()
                .orElse(null);
        return noticeBoard;
    }

    @Override
    public NoticeBoard update(NoticeBoard noticeBoard) {
        NoticeBoard oldNoticeBoard= read(noticeBoard.getFlightID());
        if(oldNoticeBoard!=null){
            noticeDB.remove(oldNoticeBoard);
            noticeDB.add(noticeBoard);
            return noticeBoard;

        }
        return null;
    }

    @Override
    public boolean delete(String FlightID) {
        NoticeBoard noticeBoardToDelete=read(FlightID);
        if (noticeBoardToDelete == null)
            return false;
        noticeDB.remove(noticeBoardToDelete);
        return true;

    }
    @Override
    public Set<NoticeBoard> getAll() {
        return noticeDB;
    }
}

