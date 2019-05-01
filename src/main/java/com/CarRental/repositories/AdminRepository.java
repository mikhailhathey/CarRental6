package com.CarRental.repositories;

import com.CarRental.domain.Admin;

import java.util.Set;


public interface AdminRepository extends CrudRepository<Admin, String> {

    Set<Admin> getAll();
}
