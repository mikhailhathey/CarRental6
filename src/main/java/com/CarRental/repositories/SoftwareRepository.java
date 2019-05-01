package com.CarRental.repositories;

import com.CarRental.domain.Software;

import java.util.Set;


public interface SoftwareRepository extends CrudRepository<Software, String> {

    Set<Software> getAll();
}
