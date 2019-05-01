package com.CarRental.repositories;

import com.CarRental.domain.Infrastructure;

import java.util.Set;


public interface InfrastructureRepository extends CrudRepository<Infrastructure, String> {

    Set<Infrastructure> getAll();
}
