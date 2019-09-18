package com.CarRental.service;

import com.CarRental.domain.Assets;

import java.util.Set;

public interface AssetsService extends CrudService<Assets, String>{
    Assets retrieveByDesc(String assetsDesc);
    Set<Assets> getAll();
}
