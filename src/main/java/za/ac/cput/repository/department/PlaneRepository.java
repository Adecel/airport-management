package za.ac.cput.repository.department;
/*
  Kissimba Nyembo Isaac
  219383448
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.department.Plane;
@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {

}
