package za.ac.cput.service.passenger;

import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.service.IService;

import java.util.List;

public interface PassengerContactService extends IService<PassengerContact,String> {

    List<PassengerContact> findAll();

}
