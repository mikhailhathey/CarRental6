package com.CarRental.repositories;

import com.CarRental.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    //Optional<Admin> findById(Integer adminId);

    //void deleteById(Integer adminId);

    //Set<Admin> getAll();
}
