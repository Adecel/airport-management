/* IRepository.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository;

public interface IRepository<ob,ID>
{
    ob Create(ob oj);
    ob Read(ID id);
    ob Update(ob oj);
    boolean delete(ID id);
}
