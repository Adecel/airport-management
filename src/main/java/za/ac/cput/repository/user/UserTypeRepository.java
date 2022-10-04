package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, String> {


}
