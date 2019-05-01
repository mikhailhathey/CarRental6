package com.CarRental.repositories.impl;

import com.CarRental.domain.Expenses;
import com.CarRental.repositories.ExpensesRepository;

import java.util.HashSet;
import java.util.Set;

public class ExpensesRepositoryImpl implements ExpensesRepository {

    private static ExpensesRepositoryImpl repository = null;
    private Set<Expenses> expenses;

    private ExpensesRepositoryImpl(){
        this.expenses = new HashSet<>();
    }

    private Expenses findExpenses(String expensesId) {
        return this.expenses.stream()
                .filter(expenses -> expenses.getExpensesId().trim().equals(expensesId))
                .findAny()
                .orElse(null);
    }

    public static ExpensesRepositoryImpl getRepository(){
        if (repository == null) repository = new ExpensesRepositoryImpl();
        return repository;
    }


    public Expenses create(Expenses expenses){
        this.expenses.add(expenses);
        return expenses;
    }

    public Expenses read(final String expensesId){
        Expenses expenses = findExpenses(expensesId);
        return expenses;
    }

    public void delete(String expensesId) {
        Expenses expenses = findExpenses(expensesId);
        if (expenses != null) this.expenses.remove(expenses);
    }

    public Expenses update(Expenses expenses){
        Expenses toDelete = findExpenses(expenses.getExpensesId());
        if(toDelete != null) {
            this.expenses.remove(toDelete);
            return create(expenses);
        }
        return null;
    }


    public Set<Expenses> getAll(){
        return this.expenses;
    }
}
