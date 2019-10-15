package com.CarRental.service;

import com.CarRental.domain.Perishables;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerishablesService extends IService<Perishables, String>{
    List<Perishables> getAll();
}
