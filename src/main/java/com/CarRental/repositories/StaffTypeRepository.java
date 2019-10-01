package com.CarRental.repositories;

import com.CarRental.domain.StaffType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffTypeRepository extends JpaRepository<StaffType, String> {

    //Set<StaffType> getAll();
}
