package com.CarRental.repositories;

import com.CarRental.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

    //Set<Supplier> getAll();
}
