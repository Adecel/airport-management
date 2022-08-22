package za.ac.cput.service.lookup.Impl;

//Mogamad Tawfeeq Cupido+
//216266882
//21 August 2022

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.repository.lookup.NoticeboardRepository;
import za.ac.cput.service.lookup.NoticeboardService;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeboardServiceImpl implements NoticeboardService {

    private final NoticeboardRepository repository;
    @Autowired
    public NoticeboardServiceImpl(NoticeboardRepository repository){
        this.repository  = repository;
    }


    @Override
    public NoticeBoard save(NoticeBoard noticeBoard) {
        return this.repository.save(noticeBoard);
    }

    @Override
    public Optional<NoticeBoard> read(String flightID) {
        return this.repository.findById(flightID);
    }

    @Override
    public void delete(NoticeBoard noticeBoard) {
        this.repository.delete(noticeBoard);
    }

    @Override
    public List<NoticeBoard> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<NoticeBoard> findById(String flightID) {
        return this.repository.findById(flightID);
    }

}
