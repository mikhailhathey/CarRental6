package com.CarRental.repositories.impl;

import com.CarRental.domain.StaffType;
import com.CarRental.repositories.StaffTypeRepository;

import java.util.HashSet;
import java.util.Set;

public class StaffTypeRepositoryImpl implements StaffTypeRepository {

    private static StaffTypeRepositoryImpl repository = null;
    private Set<StaffType> staffType;

    private StaffTypeRepositoryImpl(){
        this.staffType = new HashSet<>();
    }

    private StaffType findStaffType(String staffTypeId) {
        return this.staffType.stream()
                .filter(staffType -> staffType.getStaffTypeId().trim().equals(staffTypeId))
                .findAny()
                .orElse(null);
    }

    public static StaffTypeRepositoryImpl getRepository(){
        if (repository == null) repository = new StaffTypeRepositoryImpl();
        return repository;
    }


    public StaffType create(StaffType staffType){
        this.staffType.add(staffType);
        return staffType;
    }

    public StaffType read(final String staffTypeId){
        StaffType staffType = findStaffType(staffTypeId);
        return staffType;
    }

    public void delete(String staffTypeId) {
        StaffType staffType = findStaffType(staffTypeId);
        if (staffType != null) this.staffType.remove(staffType);
    }

    public StaffType update(StaffType staffType){
        StaffType toDelete = findStaffType(staffType.getStaffTypeId());
        if(toDelete != null) {
            this.staffType.remove(toDelete);
            return create(staffType);
        }
        return null;
    }


    public Set<StaffType> getAll(){
        return this.staffType;
    }
}
