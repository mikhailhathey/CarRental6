package com.CarRental.service;

import com.CarRental.domain.BranchLocation;

import java.util.Set;

public interface BranchLocationService extends CrudService<BranchLocation, String>{
    Set<BranchLocation> getAll();
}
