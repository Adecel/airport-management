package za.ac.cput.service.departement;

import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface LuggageService extends IService<Luggage, String> {
    List<Luggage> findAll();
    void deleteByID(String id);

    Optional<Luggage> findById(@Param("luggageID") String luggageID);
}
