package com.CarRental.service;

import com.CarRental.domain.BranchLocation;

import java.util.List;

public interface BranchLocationService extends IService<BranchLocation, String>{
    List<BranchLocation> getAll();
}
