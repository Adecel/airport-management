package za.ac.cput.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.department.Plane;
@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {

}
