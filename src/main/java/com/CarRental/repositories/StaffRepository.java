package com.CarRental.repositories;

import com.CarRental.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    //Optional<Staff> findById(Integer staffId);

    //void deleteById(Integer staffId);

    //Set<Staff> getAll();
}
