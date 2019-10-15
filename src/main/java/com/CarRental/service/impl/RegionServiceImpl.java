package com.CarRental.service.impl;

import com.CarRental.domain.Region;
import com.CarRental.repositories.RegionRepository;
import com.CarRental.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RegionServiceImpl")
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getAll() {
        return this.regionRepository.findAll();
    }

    @Override
    public Region create(Region region) {
        return this.regionRepository.save(region);
    }

    @Override
    public Region read(Integer regionId) {
        Optional<Region> byId = this.regionRepository.findById(String.valueOf(regionId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Region update(Region region) {
        return this.regionRepository.save(region);
    }

    @Override
    public void delete(Integer regionId) {
        this.regionRepository.deleteById(String.valueOf(regionId));
    }
}
