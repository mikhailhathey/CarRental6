package com.CarRental.repositories;

import com.CarRental.domain.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, String> {
    //void deleteById(Integer assetsId);

    //Optional<Assets> findById(Integer assetsId);

    //Assets retrieveByDesc(String addressDesc);
    //Set<Assets> getAll();
    //public List<Assets> findByAge(int age);
    //public List<Assets> findById(String id);

}
