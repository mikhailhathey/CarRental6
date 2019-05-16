package com.CarRental.service.impl;

import com.CarRental.domain.Revenue;
import com.CarRental.repositories.RevenueRepository;
import com.CarRental.repositories.impl.RevenueRepositoryImpl;
import com.CarRental.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RevenueServiceImpl")
public class RevenueServiceImpl implements RevenueService {
    @Autowired

    private static RevenueServiceImpl service = null;
    private RevenueRepository repository;

    private RevenueServiceImpl() {
        this.repository = RevenueRepositoryImpl.getRepository();
    }

    public static RevenueServiceImpl getService(){
        if (service == null) service = new RevenueServiceImpl();
        return service;
    }

    @Override
    public Revenue create(Revenue revenue) {
        return this.repository.create(revenue);
    }

    @Override
    public Revenue update(Revenue revenue) {
        return this.repository.update(revenue);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Revenue read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Revenue> getAll() {
        return this.repository.getAll();
    }
}
