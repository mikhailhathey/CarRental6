package com.CarRental.repositories;

import com.CarRental.domain.Claims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepository extends JpaRepository<Claims, String> {
    //Optional<Claims> findById(Integer claimsId);

    //void deleteById(Integer claimsId);

    //Set<Claims> getAll();
    //public List<Claims> findByAge(int age);
    //public List<Claims> findById(String id);

}
