package com.CarRental.repositories.impl;

import com.CarRental.domain.Region;
import com.CarRental.repositories.RegionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RegionRepositoryImpl implements RegionRepository {

    private static RegionRepositoryImpl repository = null;
    private Set<Region> region;

    private RegionRepositoryImpl(){
        this.region = new HashSet<>();
    }

    private Region findRegion(String regionId) {
        return this.region.stream()
                .filter(region -> region.getRegionId().trim().equals(regionId))
                .findAny()
                .orElse(null);
    }

    public static RegionRepositoryImpl getRepository(){
        if (repository == null) repository = new RegionRepositoryImpl();
        return repository;
    }


    public Region create(Region region){
        this.region.add(region);
        return region;
    }

    public Region read(final String regionId){
        Region region = findRegion(regionId);
        return region;
    }

    public void delete(String regionId) {
        Region region = findRegion(regionId);
        if (region != null) this.region.remove(region);
    }

    public Region update(Region region){
        Region toDelete = findRegion(region.getRegionId());
        if(toDelete != null) {
            this.region.remove(toDelete);
            return create(region);
        }
        return null;
    }


    public Set<Region> getAll(){
        return this.region;
    }
}
