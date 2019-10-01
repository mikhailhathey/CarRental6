package com.CarRental.service.impl;

import com.CarRental.domain.Claims;
import com.CarRental.repositories.ClaimsRepository;
import com.CarRental.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ClaimsServiceImpl")
public class ClaimsServiceImpl implements ClaimsService {

    @Autowired
    private ClaimsRepository claimsRepository;

    @Override
    public List<Claims> getAll() {
        return this.claimsRepository.findAll();
    }

    @Override
    public Claims create(Claims claims) {
        return this.claimsRepository.save(claims);
    }

    @Override
    public Claims read(String claimsId) {
        Optional<Claims> byId = this.claimsRepository.findById(claimsId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Claims update(Claims claims) {
        return this.claimsRepository.save(claims);
    }

    @Override
    public void delete(String claimsId) {
        this.claimsRepository.deleteById(claimsId);
    }
}
