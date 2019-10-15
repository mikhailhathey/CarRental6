package com.CarRental.service;

import com.CarRental.domain.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService extends IService<Admin, String>{
    List<Admin> getAll();
}
