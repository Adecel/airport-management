package za.ac.cput.repository;

import java.util.Optional;

public interface IRepository<A, ID> {
    A save(A a);
    Optional<A> read(ID id);
    void delete(A a);
}
