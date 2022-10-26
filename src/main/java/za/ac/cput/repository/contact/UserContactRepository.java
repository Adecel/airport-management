package za.ac.cput.repository.contact;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.contact.UserContact;

public interface UserContactRepository extends JpaRepository<UserContact, Integer> {

}
