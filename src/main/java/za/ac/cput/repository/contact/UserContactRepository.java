package za.ac.cput.repository.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.contact.UserContact;

public interface UserContactRepository extends JpaRepository<UserContact, String> {

}
