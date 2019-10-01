package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Expenses implements Comparable<Expenses>{

    @Id
    private String expensesId;
    private String expensesAmount;
    private String expensesDate;
    private String expensesContact;
    private String expensesDept;

    private Expenses(){
    }

    //expensesId, expensesAmount, expensesDate, expensesDays, expensesContact, expensesDept
    public String getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(String expensesId) {
        this.expensesId = expensesId;
    }

    public String getExpensesAmount() {
        return expensesAmount;
    }

    public void setExpensesAmount(String expensesAmount) {
        this.expensesAmount = expensesAmount;
    }

    public String getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(String expensesDate) {
        this.expensesDate = expensesDate;
    }


    public String getExpensesContact() {
        return expensesContact;
    }

    public void setExpensesContact(String expensesContact) {
        this.expensesContact = expensesContact;
    }

    public String getExpensesDept() {
        return expensesDept;
    }

    public void setExpensesDept(String expensesDept) {
        this.expensesDept = expensesDept;
    }

    public Expenses(Builder builder) {
        this.expensesId = builder.expensesId;
        this.expensesAmount = builder.expensesAmount;
        this.expensesDate = builder.expensesDate;
        this.expensesContact = builder.expensesContact;
        this.expensesDept = builder.expensesDept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expenses)) return false;
        Expenses expenses = (Expenses) o;
        return getExpensesId().equals(expenses.getExpensesId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExpensesId());
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "expensesId='" + expensesId + '\'' +
                ", expensesAmount='" + expensesAmount + '\'' +
                ", expensesDate='" + expensesDate + '\'' +
                ", expensesContact='" + expensesContact + '\'' +
                ", expensesDept='" + expensesDept + '\'' +
                '}';
    }

    @Override
    public int compareTo(Expenses expenses) {
        return this.expensesId.compareTo(expenses.expensesId);
    }

    public static class Builder{

        private String expensesId;
        private String expensesAmount;
        private String expensesDate;
        private String expensesContact;
        private String expensesDept;

        public Builder expensesId(String value)
        {
            this.expensesId = value;
            return this;
        }

        public Builder expensesAmount(String value)
        {
            this.expensesAmount = value;
            return this;
        }

        public Builder expensesDate(String value)
        {
            this.expensesDate = value;
            return this;
        }

        public Builder expensesContact(String value)
        {
            this.expensesContact = value;
            return this;
        }

        public Builder expensesDept(String value)
        {
            this.expensesDept = value;
            return this;
        }

        public Expenses build(){

            return new Expenses(this);
        }

        public Builder copy(Expenses savedExpenses) {
            this.expensesId = savedExpenses.expensesId;
            this.expensesAmount = savedExpenses.expensesAmount;
            this.expensesDate = savedExpenses.expensesDate;
            this.expensesContact = savedExpenses.expensesContact;
            this.expensesDept = savedExpenses.expensesDept;

            return this;
        }
    }
}
