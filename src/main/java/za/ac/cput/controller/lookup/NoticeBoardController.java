package za.ac.cput.controller.lookup;

//Mogamad Tawfeeq Cupido+
//216266882
//21 August 2022

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.service.lookup.NoticeboardService;

import javax.validation.Valid;
import java.util.List;


@RestController

@RequestMapping("airport-management/lookup/noticeboard/")
@Slf4j
public class NoticeBoardController {
    final NoticeboardService noticeboardService;
    @Autowired
    public NoticeBoardController(NoticeboardService noticeboardService){
        this.noticeboardService = noticeboardService;
    }

    @PostMapping("save")
    public ResponseEntity<NoticeBoard> save(@Valid @RequestBody NoticeBoard noticeBoard) throws Exception {
        log.info("Save request: {}", noticeBoard);
//        NoticeBoard obj;
//        try {
//             obj = NoticeBoardFactory.noticeBoard(noticeBoard.getFlightID(), noticeBoard.getFlightName(),noticeBoard.getDepartureTime(),noticeBoard.getArrivalTime(),noticeBoard.getDestination());
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
        NoticeBoard save = noticeboardService.save(noticeBoard);
        return ResponseEntity.ok(save);

    }

    @GetMapping("read/{flightID}")
    public ResponseEntity<NoticeBoard> read(@PathVariable String flightID) {
        log.info("Read request: {}", flightID);
        NoticeBoard noticeBoard = noticeboardService.read(flightID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(noticeBoard);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(NoticeBoard noticeBoard) {
        log.info("Delete request: {}", noticeBoard);
        this.noticeboardService.delete(noticeBoard);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<NoticeBoard>>findAll() {
        System.out.println("findAll called");
        List<NoticeBoard> noticeBoards = this.noticeboardService.findAll();
        return ResponseEntity.ok(noticeBoards);
    }


}


