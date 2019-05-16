package com.CarRental.service.impl;

import com.CarRental.domain.Software;
import com.CarRental.repositories.SoftwareRepository;
import com.CarRental.repositories.impl.SoftwareRepositoryImpl;
import com.CarRental.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("SoftwareServiceImpl")
public class SoftwareServiceImpl implements SoftwareService {
    @Autowired

    private static SoftwareServiceImpl service = null;
    private SoftwareRepository repository;

    private SoftwareServiceImpl() {
        this.repository = SoftwareRepositoryImpl.getRepository();
    }

    public static SoftwareServiceImpl getService(){
        if (service == null) service = new SoftwareServiceImpl();
        return service;
    }

    @Override
    public Software create(Software software) {
        return this.repository.create(software);
    }

    @Override
    public Software update(Software software) {
        return this.repository.update(software);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Software read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Software> getAll() {
        return this.repository.getAll();
    }
}
