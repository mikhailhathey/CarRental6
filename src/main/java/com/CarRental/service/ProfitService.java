package com.CarRental.service;

import com.CarRental.domain.Profit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfitService extends IService<Profit, String>{
    List<Profit> getAll();
}
