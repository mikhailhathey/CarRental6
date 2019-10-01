package com.CarRental.service.impl;

import com.CarRental.domain.Expenses;
import com.CarRental.repositories.ExpensesRepository;
import com.CarRental.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ExpensesServiceImpl")
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public List<Expenses> getAll() {
        return this.expensesRepository.findAll();
    }

    @Override
    public Expenses create(Expenses expenses) {
        return this.expensesRepository.save(expenses);
    }

    @Override
    public Expenses read(String expensesId) {
        Optional<Expenses> byId = this.expensesRepository.findById(expensesId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Expenses update(Expenses expenses) {
        return this.expensesRepository.save(expenses);
    }

    @Override
    public void delete(String expensesId) {
        this.expensesRepository.deleteById(expensesId);
    }
}
