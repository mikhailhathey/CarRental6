package com.CarRental.service.impl;

import com.CarRental.domain.Staff;
import com.CarRental.repositories.StaffRepository;
import com.CarRental.repositories.impl.StaffRepositoryImpl;
import com.CarRental.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("StaffServiceImpl")
public class StaffServiceImpl implements StaffService {
    @Autowired

    private static StaffServiceImpl service = null;
    private StaffRepository repository;

    private StaffServiceImpl() {
        this.repository = StaffRepositoryImpl.getRepository();
    }

    public static StaffServiceImpl getService(){
        if (service == null) service = new StaffServiceImpl();
        return service;
    }

    @Override
    public Staff create(Staff staff) {
        return this.repository.create(staff);
    }

    @Override
    public Staff update(Staff staff) {
        return this.repository.update(staff);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Staff read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Staff> getAll() {
        return this.repository.getAll();
    }
}
