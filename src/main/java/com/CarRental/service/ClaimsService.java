package com.CarRental.service;

import com.CarRental.domain.Claims;

import java.util.Set;

public interface ClaimsService extends CrudService<Claims, String>{
    Set<Claims> getAll();
}
