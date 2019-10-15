package com.CarRental.service.impl;

import com.CarRental.domain.Assets;
import com.CarRental.repositories.AssetsRepository;
import com.CarRental.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AssetsServiceImpl")
public class AssetsServiceImpl implements AssetsService {

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public List<Assets> getAll() {
        return this.assetsRepository.findAll();
    }

    @Override
    public Assets create(Assets assets) {
        return this.assetsRepository.save(assets);
    }

    @Override
    public Assets read(Integer assetsId) {
        Optional<Assets> byId = this.assetsRepository.findById(String.valueOf(assetsId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Assets update(Assets assets) {
        return this.assetsRepository.save(assets);
    }

    @Override
    public void delete(Integer assetsId) {
        this.assetsRepository.deleteById(String.valueOf(assetsId));
    }
}
