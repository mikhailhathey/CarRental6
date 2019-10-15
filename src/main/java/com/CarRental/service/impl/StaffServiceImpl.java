package com.CarRental.service.impl;

import com.CarRental.domain.Staff;
import com.CarRental.repositories.StaffRepository;
import com.CarRental.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StaffServiceImpl")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAll() {
        return this.staffRepository.findAll();
    }

    @Override
    public Staff create(Staff staff) {
        return this.staffRepository.save(staff);
    }

    @Override
    public Staff read(Integer staffId) {
        Optional<Staff> byId = this.staffRepository.findById(String.valueOf(staffId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Staff update(Staff staff) {
        return this.staffRepository.save(staff);
    }

    @Override
    public void delete(Integer staffId) {
        this.staffRepository.deleteById(String.valueOf(staffId));
    }
}
