package com.CarRental.factories;

import com.CarRental.domain.Expenses;

public class ExpensesFactory {

    public static Expenses buildExpenses(String id, String name, String password)
    {
        Expenses expenses = new Expenses.Builder()
                .expensesId(id)
                .expensesName(name)
                .password(password)
                .build();
        return expenses;
    }
}
