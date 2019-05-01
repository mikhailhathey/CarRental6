package com.CarRental.repositories;

import com.CarRental.domain.Expenses;

import java.util.Set;


public interface ExpensesRepository extends CrudRepository<Expenses, String> {

    Set<Expenses> getAll();
}
