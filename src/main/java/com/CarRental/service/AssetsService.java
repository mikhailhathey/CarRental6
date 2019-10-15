package com.CarRental.service;

import com.CarRental.domain.Assets;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetsService extends IService<Assets, String>{
    //Assets retrieveByDesc(String assetsDesc);
    List<Assets> getAll();
}
