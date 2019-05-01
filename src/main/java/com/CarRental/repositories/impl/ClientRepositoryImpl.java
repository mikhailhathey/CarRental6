package com.CarRental.repositories.impl;

import com.CarRental.domain.Client;
import com.CarRental.repositories.ClientRepository;

import java.util.HashSet;
import java.util.Set;

public class ClientRepositoryImpl implements ClientRepository {

    private static ClientRepositoryImpl repository = null;
    private Set<Client> client;

    private ClientRepositoryImpl(){
        this.client = new HashSet<>();
    }

    private Client findClient(String clientId) {
        return this.client.stream()
                .filter(client -> client.getClientId().trim().equals(clientId))
                .findAny()
                .orElse(null);
    }

    public static ClientRepositoryImpl getRepository(){
        if (repository == null) repository = new ClientRepositoryImpl();
        return repository;
    }


    public Client create(Client client){
        this.client.add(client);
        return client;
    }

    public Client read(final String clientId){
        Client client = findClient(clientId);
        return client;
    }

    public void delete(String clientId) {
        Client client = findClient(clientId);
        if (client != null) this.client.remove(client);
    }

    public Client update(Client client){
        Client toDelete = findClient(client.getClientId());
        if(toDelete != null) {
            this.client.remove(toDelete);
            return create(client);
        }
        return null;
    }


    public Set<Client> getAll(){
        return this.client;
    }
}
