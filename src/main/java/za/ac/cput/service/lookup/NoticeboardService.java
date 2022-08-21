package za.ac.cput.service.lookup;

//Mogamad Tawfeeq Cupido
//216266882
//21 August 2022

import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface NoticeboardService  extends IService<NoticeBoard, String> {

    List<NoticeBoard> findAll();

    Optional<NoticeBoard> findById(String flightID);
}
