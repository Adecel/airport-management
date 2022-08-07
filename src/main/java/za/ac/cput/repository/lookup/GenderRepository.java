/* GenderRepository.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.Gender;

import java.util.HashSet;
import java.util.Set;
@Repository
public interface GenderRepository extends JpaRepository<Gender,String>
{

}


