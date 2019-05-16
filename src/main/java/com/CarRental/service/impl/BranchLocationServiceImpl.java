package com.CarRental.service.impl;

import com.CarRental.domain.BranchLocation;
import com.CarRental.repositories.BranchLocationRepository;
import com.CarRental.repositories.impl.BranchLocationRepositoryImpl;
import com.CarRental.service.BranchLocationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BranchLocationServiceImpl implements BranchLocationService {

    private static BranchLocationServiceImpl service = null;
    private BranchLocationRepository repository;

    private BranchLocationServiceImpl() {
        this.repository = BranchLocationRepositoryImpl.getRepository();
    }

    public static BranchLocationServiceImpl getService(){
        if (service == null) service = new BranchLocationServiceImpl();
        return service;
    }

    @Override
    public BranchLocation create(BranchLocation branchLocation) {
        return this.repository.create(branchLocation);
    }

    @Override
    public BranchLocation update(BranchLocation branchLocation) {
        return this.repository.update(branchLocation);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public BranchLocation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<BranchLocation> getAll() {
        return this.repository.getAll();
    }
}
