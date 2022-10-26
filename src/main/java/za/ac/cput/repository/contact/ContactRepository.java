package za.ac.cput.repository.contact;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.contact.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
