package com.CarRental.service.impl;

import com.CarRental.domain.Expenses;
import com.CarRental.repositories.ExpensesRepository;
import com.CarRental.repositories.impl.ExpensesRepositoryImpl;
import com.CarRental.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ExpensesServiceImpl")
public class ExpensesServiceImpl implements ExpensesService {
    @Autowired

    private static ExpensesServiceImpl service = null;
    private ExpensesRepository repository;

    private ExpensesServiceImpl() {
        this.repository = ExpensesRepositoryImpl.getRepository();
    }

    public static ExpensesServiceImpl getService(){
        if (service == null) service = new ExpensesServiceImpl();
        return service;
    }

    @Override
    public Expenses create(Expenses expenses) {
        return this.repository.create(expenses);
    }

    @Override
    public Expenses update(Expenses expenses) {
        return this.repository.update(expenses);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Expenses read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Expenses> getAll() {
        return this.repository.getAll();
    }
}
