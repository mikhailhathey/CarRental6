package com.CarRental.repositories;

import com.CarRental.domain.Client;

import java.util.Set;


public interface ClientRepository extends CrudRepository<Client, String> {

    Set<Client> getAll();
    //public List<Client> findByAge(int age);
    //public List<Client> findById(String id);

}
