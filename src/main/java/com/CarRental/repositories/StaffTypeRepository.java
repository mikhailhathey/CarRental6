package com.CarRental.repositories;

import com.CarRental.domain.StaffType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffTypeRepository extends JpaRepository<StaffType, String> {
    //Optional<StaffType> findById(Integer staffTypeId);

    //void deleteById(Integer staffTypeId);

    //Set<StaffType> getAll();
}
