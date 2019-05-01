package com.CarRental.repositories;

import com.CarRental.domain.Profit;

import java.util.Set;


public interface ProfitRepository extends CrudRepository<Profit, String> {

    Set<Profit> getAll();
}
