package com.CarRental.service;

import com.CarRental.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService extends IService<Client, String>{
    List<Client> getAll();
}
