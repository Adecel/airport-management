package za.ac.cput.service;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import java.util.Optional;

public interface IService <A, ID>{
    A save(A a) throws Exception;
    Optional<A> read(ID id);
    void delete(A a);
}
