package com.CarRental.service;

import com.CarRental.domain.BranchLocation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BranchLocationService extends IService<BranchLocation, String>{
    List<BranchLocation> getAll();
}
