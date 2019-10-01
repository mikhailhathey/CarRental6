package com.CarRental.repositories;

import com.CarRental.domain.FleetManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetManagerRepository extends JpaRepository<FleetManager, String> {

    //Set<FleetManager> getAll();
}
