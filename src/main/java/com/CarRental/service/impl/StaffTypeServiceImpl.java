package com.CarRental.service.impl;

import com.CarRental.domain.StaffType;
import com.CarRental.repositories.StaffTypeRepository;
import com.CarRental.repositories.impl.StaffTypeRepositoryImpl;
import com.CarRental.service.StaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("StaffTypeServiceImpl")
public class StaffTypeServiceImpl implements StaffTypeService {
    @Autowired

    private static StaffTypeServiceImpl service = null;
    private StaffTypeRepository repository;

    private StaffTypeServiceImpl() {
        this.repository = StaffTypeRepositoryImpl.getRepository();
    }

    public static StaffTypeServiceImpl getService(){
        if (service == null) service = new StaffTypeServiceImpl();
        return service;
    }

    @Override
    public StaffType create(StaffType staffType) {
        return this.repository.create(staffType);
    }

    @Override
    public StaffType update(StaffType staffType) {
        return this.repository.update(staffType);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public StaffType read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<StaffType> getAll() {
        return this.repository.getAll();
    }
}
