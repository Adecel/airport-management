package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.lookup.RunWay;


import java.util.Optional;

public interface RunWayRepository extends JpaRepository<RunWay, String> {
    Optional<RunWay> findById(@Param("runwayNumber") String runwayNumber);
}
