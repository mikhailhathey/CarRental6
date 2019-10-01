package com.CarRental.service;

import com.CarRental.domain.Region;

import java.util.List;

public interface RegionService extends IService<Region, String>{
    List<Region> getAll();
}
