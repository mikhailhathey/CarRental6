package com.CarRental.repositories;

import com.CarRental.domain.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, String> {
    //Optional<Revenue> findById(Integer revenueId);

    //void deleteById(Integer revenueId);

    //Set<Revenue> getAll();
}
