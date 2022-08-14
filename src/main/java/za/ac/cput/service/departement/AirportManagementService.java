package za.ac.cput.service.departement;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.service.IService;

import java.util.List;

public interface AirportManagementService extends IService<AirportManagement, String> {
    List<AirportManagement> findByAirportName(String airportName);
}
