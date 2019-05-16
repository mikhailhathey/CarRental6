package com.CarRental.service;

import com.CarRental.domain.Revenue;

import java.util.Set;

public interface RevenueService extends CrudService<Revenue, String>{
    Set<Revenue> getAll();
}
