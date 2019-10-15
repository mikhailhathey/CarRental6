package com.CarRental.service.impl;

import com.CarRental.domain.Client;
import com.CarRental.repositories.ClientRepository;
import com.CarRental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client read(Integer clientId) {
        Optional<Client> byId = this.clientRepository.findById(String.valueOf(clientId));
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Client update(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public void delete(Integer clientId) {
        this.clientRepository.deleteById(String.valueOf(clientId));
    }
}
