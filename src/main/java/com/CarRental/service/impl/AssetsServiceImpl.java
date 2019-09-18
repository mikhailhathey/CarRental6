package com.CarRental.service.impl;

import com.CarRental.domain.Assets;
import com.CarRental.repositories.AssetsRepository;
import com.CarRental.repositories.impl.AssetsRepositoryImpl;
import com.CarRental.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AssetsServiceImpl")
public class AssetsServiceImpl implements AssetsService {
    @Autowired

    private static AssetsServiceImpl service = null;
    private AssetsRepository assetsRepository;

    private AssetsServiceImpl() {
        this.assetsRepository = AssetsRepositoryImpl.getRepository();
    }

    public static AssetsServiceImpl getService(){
        if (service == null) service = new AssetsServiceImpl();
        return service;
    }

    @Override
    public Assets create(Assets assets) {
        return this.assetsRepository.create(assets);
    }

    @Override
    public Assets update(Assets assets) {
        return this.assetsRepository.update(assets);
    }

    @Override
    public void delete(String s) {
        this.assetsRepository.delete(s);
    }

    @Override
    public Assets read(String s) {
        return this.assetsRepository.read(s);
    }

    @Override
    public Assets retrieveByDesc(String assetsDesc) {
        return this.assetsRepository.retrieveByDesc(assetsDesc);
    }

    @Override
    public Set<Assets> getAll() {
        return this.assetsRepository.getAll();
    }
}
