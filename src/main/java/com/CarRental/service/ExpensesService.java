package com.CarRental.service;

import com.CarRental.domain.Expenses;

import java.util.Set;

public interface ExpensesService extends CrudService<Expenses, String>{
    Set<Expenses> getAll();
}
