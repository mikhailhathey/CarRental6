package com.CarRental.service;

import com.CarRental.domain.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionService extends IService<Region, String>{
    List<Region> getAll();
}
