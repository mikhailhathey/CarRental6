package com.CarRental.repositories;

import com.CarRental.domain.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfrastructureRepository extends JpaRepository<Infrastructure, String> {

    //Set<Infrastructure> getAll();
}
