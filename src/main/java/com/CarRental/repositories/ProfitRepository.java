package com.CarRental.repositories;

import com.CarRental.domain.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitRepository extends JpaRepository<Profit, String> {
    //Optional<Profit> findById(Integer profitId);

    //void deleteById(Integer profitId);

    //Set<Profit> getAll();
}
