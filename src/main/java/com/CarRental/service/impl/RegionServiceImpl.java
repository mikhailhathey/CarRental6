package com.CarRental.service.impl;

import com.CarRental.domain.Region;
import com.CarRental.repositories.RegionRepository;
import com.CarRental.repositories.impl.RegionRepositoryImpl;
import com.CarRental.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RegionServiceImpl")
public class RegionServiceImpl implements RegionService {
    @Autowired

    private static RegionServiceImpl service = null;
    private RegionRepository repository;

    private RegionServiceImpl() {
        this.repository = RegionRepositoryImpl.getRepository();
    }

    public static RegionServiceImpl getService(){
        if (service == null) service = new RegionServiceImpl();
        return service;
    }

    @Override
    public Region create(Region region) {
        return this.repository.create(region);
    }

    @Override
    public Region update(Region region) {
        return this.repository.update(region);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Region read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Region> getAll() {
        return this.repository.getAll();
    }
}
