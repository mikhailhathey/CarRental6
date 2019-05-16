package com.CarRental.service.impl;

import com.CarRental.domain.Assets;
import com.CarRental.repositories.AssetsRepository;
import com.CarRental.repositories.impl.AssetsRepositoryImpl;
import com.CarRental.service.AssetsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AssetsServiceImpl implements AssetsService {

    private static AssetsServiceImpl service = null;
    private AssetsRepository repository;

    private AssetsServiceImpl() {
        this.repository = AssetsRepositoryImpl.getRepository();
    }

    public static AssetsServiceImpl getService(){
        if (service == null) service = new AssetsServiceImpl();
        return service;
    }

    @Override
    public Assets create(Assets assets) {
        return this.repository.create(assets);
    }

    @Override
    public Assets update(Assets assets) {
        return this.repository.update(assets);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Assets read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Assets> getAll() {
        return this.repository.getAll();
    }
}
