package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,String> {

    List<Contact> findContactsByConId(String ID);

}
