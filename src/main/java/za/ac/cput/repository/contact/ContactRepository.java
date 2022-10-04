package za.ac.cput.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.contact.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
