package com.CarRental.repositories;

import com.CarRental.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends JpaRepository<Hardware, String> {
    //Optional<Hardware> findById(Integer hardwareId);

    //void deleteById(Integer hardwareId);

    //Set<Hardware> getAll();
}
