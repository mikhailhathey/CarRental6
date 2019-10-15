package com.CarRental.service;

import com.CarRental.domain.Revenue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RevenueService extends IService<Revenue, String>{
    List<Revenue> getAll();
}
