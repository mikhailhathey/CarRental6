package com.CarRental.service.impl;

import com.CarRental.domain.Infrastructure;
import com.CarRental.repositories.InfrastructureRepository;
import com.CarRental.repositories.impl.InfrastructureRepositoryImpl;
import com.CarRental.service.InfrastructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("InfrastructureServiceImpl")
public class InfrastructureServiceImpl implements InfrastructureService {
    @Autowired

    private static InfrastructureServiceImpl service = null;
    private InfrastructureRepository repository;

    private InfrastructureServiceImpl() {
        this.repository = InfrastructureRepositoryImpl.getRepository();
    }

    public static InfrastructureServiceImpl getService(){
        if (service == null) service = new InfrastructureServiceImpl();
        return service;
    }

    @Override
    public Infrastructure create(Infrastructure infrastructure) {
        return this.repository.create(infrastructure);
    }

    @Override
    public Infrastructure update(Infrastructure infrastructure) {
        return this.repository.update(infrastructure);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Infrastructure read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Infrastructure> getAll() {
        return this.repository.getAll();
    }
}
