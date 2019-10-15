package com.CarRental.repositories;

import com.CarRental.domain.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, String> {
    //Optional<Expenses> findById(Integer expensesId);

    //void deleteById(Integer expensesId);

    //Set<Expenses> getAll();
}
