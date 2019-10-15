package com.CarRental.service;

import com.CarRental.domain.Software;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SoftwareService extends IService<Software, String>{
    List<Software> getAll();
}
