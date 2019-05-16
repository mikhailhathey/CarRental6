package com.CarRental.service;

import com.CarRental.domain.Client;

import java.util.Set;

public interface ClientService extends CrudService<Client, String>{
    Set<Client> getAll();
}
