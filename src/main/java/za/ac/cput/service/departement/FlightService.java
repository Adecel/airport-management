package za.ac.cput.service.departement;

import za.ac.cput.domain.department.Flight;
import za.ac.cput.service.IService;

import java.util.List;

public interface FlightService extends IService<Flight, String> {

    List<Flight>  findAll();
}