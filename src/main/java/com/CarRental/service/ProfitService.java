package com.CarRental.service;

import com.CarRental.domain.Profit;

import java.util.Set;

public interface ProfitService extends CrudService<Profit, String>{
    Set<Profit> getAll();
}
