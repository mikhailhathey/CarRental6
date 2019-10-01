package com.CarRental.repositories;

import com.CarRental.domain.RentalTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalTermRepository extends JpaRepository<RentalTerm, String> {

    //Set<RentalTerm> getAll();
}
