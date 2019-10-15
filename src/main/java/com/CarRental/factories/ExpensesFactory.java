package com.CarRental.factories;

import com.CarRental.domain.Expenses;

public class ExpensesFactory {

    public static Expenses buildExpenses(Integer expensesId, String expensesAmount, String expensesDate, String expensesContact, String expensesDept)
    {
        return new Expenses.Builder()
                .expensesId(expensesId)
                .expensesAmount(expensesAmount)
                .expensesDate(expensesDate)
                .expensesContact(expensesContact)
                .expensesDept(expensesDept)
                .build();
    }
}
