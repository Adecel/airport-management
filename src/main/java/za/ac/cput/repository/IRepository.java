package za.ac.cput.repository;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

public interface IRepository <A, ID>{
    A create (A a);
    A read(ID id);
    A update(A a);
    boolean delete(ID id);
}
