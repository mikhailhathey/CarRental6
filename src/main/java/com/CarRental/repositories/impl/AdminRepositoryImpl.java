package com.CarRental.repositories.impl;

import com.CarRental.domain.Admin;
import com.CarRental.repositories.AdminRepository;


public class AdminRepositoryImpl implements AdminRepository {

    private static AdminRepositoryImpl repository = null;
    private Set<Admin> admin;

    private AdminRepositoryImpl(){
        this.admin = new HashSet<>();
    }

    private Admin findAdmin(String adminId) {
        return this.admin.stream()
                .filter(admin -> admin.getAdminId().trim().equals(adminId))
                .findAny()
                .orElse(null);
    }

    public static AdminRepositoryImpl getRepository(){
        if (repository == null) repository = new AdminRepositoryImpl();
        return repository;
    }


    public Admin create(Admin admin){
        this.admin.add(admin);
        return admin;
    }

    public Admin read(final String adminId){
        Admin admin = findAdmin(adminId);
        return admin;
    }

    public void delete(String adminId) {
        Admin admin = findAdmin(adminId);
        if (admin != null) this.admin.remove(admin);
    }

    public Admin update(Admin admin){
        Admin toDelete = findAdmin(admin.getAdminId());
        if(toDelete != null) {
            this.admin.remove(toDelete);
            return create(admin);
        }
        return null;
    }


    public Set<Admin> getAll(){
        return this.admin;
    }
}
