package za.ac.cput.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.Plane;

public interface PlaneRepository extends JpaRepository<Plane, String> {

}
