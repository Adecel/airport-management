package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.Pilot;
@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {

}
