package com.CarRental.service.impl;

import com.CarRental.domain.Admin;
import com.CarRental.repositories.AdminRepository;
import com.CarRental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAll() {
        return this.adminRepository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin read(Integer adminId) {
        Optional<Admin> byId = this.adminRepository.findById(String.valueOf(adminId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public void delete(Integer adminId) {
        this.adminRepository.deleteById(String.valueOf(adminId));
    }
}
