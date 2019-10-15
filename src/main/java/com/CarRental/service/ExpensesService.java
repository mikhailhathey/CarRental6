package com.CarRental.service;

import com.CarRental.domain.Expenses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpensesService extends IService<Expenses, String>{
    List<Expenses> getAll();
}
