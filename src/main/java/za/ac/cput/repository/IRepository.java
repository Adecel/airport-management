package za.ac.cput.repository;

public interface IRepository <A, ID>{
    A create (A a);
    A read(ID id);
    A update(A a);
    boolean delete(ID id);
}
