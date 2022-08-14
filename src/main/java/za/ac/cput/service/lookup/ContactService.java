package za.ac.cput.service.lookup;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.service.IService;

import java.util.List;

public interface ContactService  extends IService<Contact,String> {

    List<Contact> findAll();
}

