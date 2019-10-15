package com.CarRental.repositories;

import com.CarRental.domain.BranchLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchLocationRepository extends JpaRepository<BranchLocation, String> {
    //Optional<BranchLocation> findById(Integer branchLocationId);

    //void deleteById(Integer branchLocationId);

    //Set<BranchLocation> getAll();
    //public List<BranchLocation> findByAge(int age);
    //public List<BranchLocation> findById(String id);

}
