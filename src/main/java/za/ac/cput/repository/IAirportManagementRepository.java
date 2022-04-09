package za.ac.cput.repository;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.entity.AirportManagement;

import java.util.Set;

public interface IAirportManagementRepository extends IRepository<AirportManagement, String> {
        public Set<AirportManagement> getAll();
}
