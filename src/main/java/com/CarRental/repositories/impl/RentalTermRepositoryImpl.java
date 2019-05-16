package com.CarRental.repositories.impl;

import com.CarRental.domain.RentalTerm;
import com.CarRental.repositories.RentalTermRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RentalTermRepositoryImpl implements RentalTermRepository {

    private static RentalTermRepositoryImpl repository = null;
    private Set<RentalTerm> rentalTerm;

    private RentalTermRepositoryImpl(){
        this.rentalTerm = new HashSet<>();
    }

    private RentalTerm findRentalTerm(String rentalTermId) {
        return this.rentalTerm.stream()
                .filter(rentalTerm -> rentalTerm.getRentalTermId().trim().equals(rentalTermId))
                .findAny()
                .orElse(null);
    }

    public static RentalTermRepositoryImpl getRepository(){
        if (repository == null) repository = new RentalTermRepositoryImpl();
        return repository;
    }


    public RentalTerm create(RentalTerm rentalTerm){
        this.rentalTerm.add(rentalTerm);
        return rentalTerm;
    }

    public RentalTerm read(final String rentalTermId){
        RentalTerm rentalTerm = findRentalTerm(rentalTermId);
        return rentalTerm;
    }

    public void delete(String rentalTermId) {
        RentalTerm rentalTerm = findRentalTerm(rentalTermId);
        if (rentalTerm != null) this.rentalTerm.remove(rentalTerm);
    }

    public RentalTerm update(RentalTerm rentalTerm){
        RentalTerm toDelete = findRentalTerm(rentalTerm.getRentalTermId());
        if(toDelete != null) {
            this.rentalTerm.remove(toDelete);
            return create(rentalTerm);
        }
        return null;
    }


    public Set<RentalTerm> getAll(){
        return this.rentalTerm;
    }
}
