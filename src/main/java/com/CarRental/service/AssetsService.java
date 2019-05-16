package com.CarRental.service;

import com.CarRental.domain.Assets;

import java.util.Set;

public interface AssetsService extends CrudService<Assets, String>{
    Set<Assets> getAll();
}
