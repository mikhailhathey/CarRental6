package com.CarRental.repositories;

import com.CarRental.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, String> {
    //Optional<Region> findById(Integer regionId);

    //void deleteById(Integer regionId);

    //Set<Region> getAll();
}
