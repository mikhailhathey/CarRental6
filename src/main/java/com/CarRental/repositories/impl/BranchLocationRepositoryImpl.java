package com.CarRental.repositories.impl;

import com.CarRental.domain.BranchLocation;
import com.CarRental.repositories.BranchLocationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class BranchLocationRepositoryImpl implements BranchLocationRepository {

    private static BranchLocationRepositoryImpl repository = null;
    private Set<BranchLocation> branchLocation;

    private BranchLocationRepositoryImpl(){
        this.branchLocation = new HashSet<>();
    }

    private BranchLocation findBranchLocation(String branchLocationId) {
        return this.branchLocation.stream()
                .filter(branchLocation -> branchLocation.getBranchLocationId().trim().equals(branchLocationId))
                .findAny()
                .orElse(null);
    }

    public static BranchLocationRepositoryImpl getRepository(){
        if (repository == null) repository = new BranchLocationRepositoryImpl();
        return repository;
    }


    public BranchLocation create(BranchLocation branchLocation){
        this.branchLocation.add(branchLocation);
        return branchLocation;
    }

    public BranchLocation read(final String branchLocationId){
        BranchLocation branchLocation = findBranchLocation(branchLocationId);
        return branchLocation;
    }

    public void delete(String branchLocationId) {
        BranchLocation branchLocation = findBranchLocation(branchLocationId);
        if (branchLocation != null) this.branchLocation.remove(branchLocation);
    }

    public BranchLocation update(BranchLocation branchLocation){
        BranchLocation toDelete = findBranchLocation(branchLocation.getBranchLocationId());
        if(toDelete != null) {
            this.branchLocation.remove(toDelete);
            return create(branchLocation);
        }
        return null;
    }


    public Set<BranchLocation> getAll(){
        return this.branchLocation;
    }
}
