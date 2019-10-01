package com.CarRental.repositories;

import com.CarRental.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    //Set<Client> getAll();
    //public List<Client> findByAge(int age);
    //public List<Client> findById(String id);

}
