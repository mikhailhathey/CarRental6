package com.CarRental.service.impl;

import com.CarRental.domain.StaffType;
import com.CarRental.repositories.StaffTypeRepository;
import com.CarRental.service.StaffTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StaffTypeServiceImpl")
public class StaffTypeServiceImpl implements StaffTypeService {

    @Autowired
    private StaffTypeRepository staffTypeRepository;

    @Override
    public List<StaffType> getAll() {
        return this.staffTypeRepository.findAll();
    }

    @Override
    public StaffType create(StaffType staffType) {
        return this.staffTypeRepository.save(staffType);
    }

    @Override
    public StaffType read(String staffTypeId) {
        Optional<StaffType> byId = this.staffTypeRepository.findById(staffTypeId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public StaffType update(StaffType staffType) {
        return this.staffTypeRepository.save(staffType);
    }

    @Override
    public void delete(String staffTypeId) {
        this.staffTypeRepository.deleteById(staffTypeId);
    }
}
