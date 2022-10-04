package za.ac.cput.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.contact.ContactType;

public interface ContactTypeRepository extends JpaRepository<ContactType, String> {

}
