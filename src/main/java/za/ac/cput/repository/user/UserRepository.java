package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {

}
