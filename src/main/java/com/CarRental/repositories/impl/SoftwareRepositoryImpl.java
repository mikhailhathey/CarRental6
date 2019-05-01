package com.CarRental.repositories.impl;

import com.CarRental.domain.Software;
import com.CarRental.repositories.SoftwareRepository;

import java.util.HashSet;
import java.util.Set;

public class SoftwareRepositoryImpl implements SoftwareRepository {


    private static SoftwareRepositoryImpl repository = null;
    private Set<Software> software;

    private SoftwareRepositoryImpl(){
        this.software = new HashSet<>();
    }

    private Software findSoftware(String softwareId) {
        return this.software.stream()
                .filter(software -> software.getSoftwareId().trim().equals(softwareId))
                .findAny()
                .orElse(null);
    }

    public static SoftwareRepositoryImpl getRepository(){
        if (repository == null) repository = new SoftwareRepositoryImpl();
        return repository;
    }


    public Software create(Software software){
        this.software.add(software);
        return software;
    }

    public Software read(final String softwareId){
        Software software = findSoftware(softwareId);
        return software;
    }

    public void delete(String softwareId) {
        Software software = findSoftware(softwareId);
        if (software != null) this.software.remove(software);
    }

    public Software update(Software software){
        Software toDelete = findSoftware(software.getSoftwareId());
        if(toDelete != null) {
            this.software.remove(toDelete);
            return create(software);
        }
        return null;
    }


    public Set<Software> getAll(){
        return this.software;
    }
}
