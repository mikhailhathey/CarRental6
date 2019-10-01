package com.CarRental.repositories;

import com.CarRental.domain.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, String> {

    //Set<Software> getAll();
}
