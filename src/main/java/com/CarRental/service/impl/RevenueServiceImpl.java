package com.CarRental.service.impl;

import com.CarRental.domain.Revenue;
import com.CarRental.repositories.RevenueRepository;
import com.CarRental.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RevenueServiceImpl")
public class RevenueServiceImpl implements RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    @Override
    public List<Revenue> getAll() {
        return this.revenueRepository.findAll();
    }

    @Override
    public Revenue create(Revenue revenue) {
        return this.revenueRepository.save(revenue);
    }

    @Override
    public Revenue read(Integer revenueId) {
        Optional<Revenue> byId = this.revenueRepository.findById(String.valueOf(revenueId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Revenue update(Revenue revenue) {
        return this.revenueRepository.save(revenue);
    }

    @Override
    public void delete(Integer revenueId) {
        this.revenueRepository.deleteById(String.valueOf(revenueId));
    }
}
