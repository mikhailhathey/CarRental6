package com.CarRental.service.impl;

import com.CarRental.domain.Admin;
import com.CarRental.repositories.AdminRepository;
import com.CarRental.repositories.impl.AdminRepositoryImpl;
import com.CarRental.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository repository;

    private static AdminServiceImpl service = null;

    private AdminServiceImpl() {
        this.repository = AdminRepositoryImpl.getRepository();
    }

    public static AdminServiceImpl getService(){
        if (service == null) service = new AdminServiceImpl();
        return service;
    }

    @Override
    public Admin create(Admin admin) {
        return this.repository.create(admin);
    }

    @Override
    public Admin update(Admin admin) {
        return this.repository.update(admin);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Admin read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Admin> getAll() {
        return this.repository.getAll();
    }
}
