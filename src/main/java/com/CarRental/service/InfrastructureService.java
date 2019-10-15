package com.CarRental.service;

import com.CarRental.domain.Infrastructure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InfrastructureService extends IService<Infrastructure, String>{
    List<Infrastructure> getAll();
}
