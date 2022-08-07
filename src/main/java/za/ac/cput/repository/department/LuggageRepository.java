package za.ac.cput.repository.department;

//219383448 KISSIMBA NYEMBO ISAAC

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.department.Luggage;
import java.util.Optional;


@Repository
public interface LuggageRepository extends JpaRepository<Luggage, String> {
    Optional<Luggage> findById(@Param("luggageID") String luggageID);
}