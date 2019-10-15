package com.CarRental.repositories;

import com.CarRental.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    //Optional<Contact> findById(Integer contactId);

    //void deleteById(Integer contactId);

    //Set<Contact> getAll();
}
