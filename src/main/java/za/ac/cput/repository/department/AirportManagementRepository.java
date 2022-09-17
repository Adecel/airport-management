package za.ac.cput.repository.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.department.AirportManagement;

@Repository
public interface AirportManagementRepository extends JpaRepository<AirportManagement, String> {
    AirportManagement findByAirportName(String airportName);
    void deleteAirportName(String airportName);

    void delete(String airportManagement);
}
