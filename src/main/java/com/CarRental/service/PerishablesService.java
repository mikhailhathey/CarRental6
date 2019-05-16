package com.CarRental.service;

import com.CarRental.domain.Perishables;

import java.util.Set;

public interface PerishablesService extends CrudService<Perishables, String>{
    Set<Perishables> getAll();
}
