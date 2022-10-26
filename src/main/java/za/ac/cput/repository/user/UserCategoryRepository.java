package za.ac.cput.repository.user;
/*
  Adecel Rusty Mabiala
  219197229
 */
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.UserCategory;

public interface UserCategoryRepository extends JpaRepository<UserCategory, String> {

}
