package za.ac.cput.service.lookup;

import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.lookup.RunWay;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface RunWayService extends IService<RunWay, String> {
        List<RunWay> findAll();
        void deleteByID(String id);

        Optional<RunWay> findById(@Param("runwayNumber") String runwayNumber);
}
