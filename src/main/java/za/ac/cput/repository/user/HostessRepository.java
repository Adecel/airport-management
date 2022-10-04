package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.Hostess;

public interface HostessRepository extends JpaRepository<Hostess, String> {

}
