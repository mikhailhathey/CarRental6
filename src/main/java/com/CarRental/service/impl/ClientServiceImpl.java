package com.CarRental.service.impl;

import com.CarRental.domain.Client;
import com.CarRental.repositories.ClientRepository;
import com.CarRental.repositories.impl.ClientRepositoryImpl;
import com.CarRental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientService {
    @Autowired

    private static ClientServiceImpl service = null;
    private ClientRepository repository;

    private ClientServiceImpl() {
        this.repository = ClientRepositoryImpl.getRepository();
    }

    public static ClientServiceImpl getService(){
        if (service == null) service = new ClientServiceImpl();
        return service;
    }

    @Override
    public Client create(Client client) {
        return this.repository.create(client);
    }

    @Override
    public Client update(Client client) {
        return this.repository.update(client);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Client read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Client> getAll() {
        return this.repository.getAll();
    }
}
