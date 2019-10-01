package com.CarRental.service;

import com.CarRental.domain.Client;

import java.util.List;

public interface ClientService extends IService<Client, String>{
    List<Client> getAll();
}
