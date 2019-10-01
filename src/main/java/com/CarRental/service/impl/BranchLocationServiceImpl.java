package com.CarRental.service.impl;

import com.CarRental.domain.BranchLocation;
import com.CarRental.repositories.BranchLocationRepository;
import com.CarRental.service.BranchLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("BranchLocationServiceImpl")
public class BranchLocationServiceImpl implements BranchLocationService {

    @Autowired
    private BranchLocationRepository branchLocationRepository;

    @Override
    public List<BranchLocation> getAll() {
        return this.branchLocationRepository.findAll();
    }

    @Override
    public BranchLocation create(BranchLocation branchLocation) {
        return this.branchLocationRepository.save(branchLocation);
    }

    @Override
    public BranchLocation read(String branchLocationId) {
        Optional<BranchLocation> byId = this.branchLocationRepository.findById(branchLocationId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public BranchLocation update(BranchLocation branchLocation) {
        return this.branchLocationRepository.save(branchLocation);
    }

    @Override
    public void delete(String branchLocationId) {
        this.branchLocationRepository.deleteById(branchLocationId);
    }
}
