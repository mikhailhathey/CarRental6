package com.CarRental.service;

import com.CarRental.domain.Perishables;

import java.util.List;

public interface PerishablesService extends IService<Perishables, String>{
    List<Perishables> getAll();
}
