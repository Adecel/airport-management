package za.ac.cput.repository;

import za.ac.cput.domain.entity.AirportManagement;

import java.util.Set;

public interface IAirportManagementRepository extends IRepository<AirportManagement, String> {
        public Set<AirportManagement> getAll();
}
