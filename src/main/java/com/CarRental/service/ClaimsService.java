package com.CarRental.service;

import com.CarRental.domain.Claims;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClaimsService extends IService<Claims, String>{
    List<Claims> getAll();
}
