package com.CarRental.service;

import com.CarRental.domain.Claims;

import java.util.List;

public interface ClaimsService extends IService<Claims, String>{
    List<Claims> getAll();
}
