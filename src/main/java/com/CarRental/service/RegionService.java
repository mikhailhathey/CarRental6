package com.CarRental.service;

import com.CarRental.domain.Region;

import java.util.Set;

public interface RegionService extends CrudService<Region, String>{
    Set<Region> getAll();
}
