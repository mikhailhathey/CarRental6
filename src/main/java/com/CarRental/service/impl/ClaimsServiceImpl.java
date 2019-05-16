package com.CarRental.service.impl;

import com.CarRental.domain.Claims;
import com.CarRental.repositories.ClaimsRepository;
import com.CarRental.repositories.impl.ClaimsRepositoryImpl;
import com.CarRental.service.ClaimsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClaimsServiceImpl implements ClaimsService {

    private static ClaimsServiceImpl service = null;
    private ClaimsRepository repository;

    private ClaimsServiceImpl() {
        this.repository = ClaimsRepositoryImpl.getRepository();
    }

    public static ClaimsServiceImpl getService(){
        if (service == null) service = new ClaimsServiceImpl();
        return service;
    }

    @Override
    public Claims create(Claims claims) {
        return this.repository.create(claims);
    }

    @Override
    public Claims update(Claims claims) {
        return this.repository.update(claims);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Claims read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Claims> getAll() {
        return this.repository.getAll();
    }
}
