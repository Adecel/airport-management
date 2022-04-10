/* IPassengerGender.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.entity.PassengerGender;

import java.util.Set;

public interface IPassengerGender extends  IRepository <PassengerGender, String>
{
    public Set<PassengerGender> getAll();
}
