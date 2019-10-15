package com.CarRental.repositories;

import com.CarRental.domain.Perishables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerishablesRepository extends JpaRepository<Perishables, String> {
    //Optional<Perishables> findById(Integer perishablesId);

    //void deleteById(Integer perishablesId);

    //Set<Perishables> getAll();
}
