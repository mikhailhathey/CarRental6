package com.CarRental.service;

import com.CarRental.domain.Assets;

import java.util.List;

public interface AssetsService extends IService<Assets, String>{
    //Assets retrieveByDesc(String assetsDesc);
    List<Assets> getAll();
}
