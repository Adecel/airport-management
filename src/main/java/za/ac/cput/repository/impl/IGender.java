/* IGender.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.Gender;

import java.util.Set;

public interface IGender extends  IRepository <Gender, String>
{
    public Set<Gender> getAll();
}
