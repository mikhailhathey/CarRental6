package com.CarRental.service.impl;

import com.CarRental.domain.Profit;
import com.CarRental.repositories.ProfitRepository;
import com.CarRental.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProfitServiceImpl")
public class ProfitServiceImpl implements ProfitService {

    @Autowired
    private ProfitRepository profitRepository;

    @Override
    public List<Profit> getAll() {
        return this.profitRepository.findAll();
    }

    @Override
    public Profit create(Profit profit) {
        return this.profitRepository.save(profit);
    }

    @Override
    public Profit read(String profitId) {
        Optional<Profit> byId = this.profitRepository.findById(profitId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Profit update(Profit profit) {
        return this.profitRepository.save(profit);
    }

    @Override
    public void delete(String profitId) {
        this.profitRepository.deleteById(profitId);
    }
}
