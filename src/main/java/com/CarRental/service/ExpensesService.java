package com.CarRental.service;

import com.CarRental.domain.Expenses;

import java.util.List;

public interface ExpensesService extends IService<Expenses, String>{
    List<Expenses> getAll();
}
