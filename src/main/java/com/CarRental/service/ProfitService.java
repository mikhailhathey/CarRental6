package com.CarRental.service;

import com.CarRental.domain.Profit;

import java.util.List;

public interface ProfitService extends IService<Profit, String>{
    List<Profit> getAll();
}
