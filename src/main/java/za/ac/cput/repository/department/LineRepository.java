package za.ac.cput.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.Line;

public interface LineRepository extends JpaRepository<Line, String> {

}
