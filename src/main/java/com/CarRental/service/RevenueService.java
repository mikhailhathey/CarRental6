package com.CarRental.service;

import com.CarRental.domain.Revenue;

import java.util.List;

public interface RevenueService extends IService<Revenue, String>{
    List<Revenue> getAll();
}
