package com.CarRental.repositories.impl;

import com.CarRental.domain.Perishables;
import com.CarRental.repositories.PerishablesRepository;

import java.util.HashSet;
import java.util.Set;

public class PerishablesRepositoryImpl implements PerishablesRepository {

    private static PerishablesRepositoryImpl repository = null;
    private Set<Perishables> perishables;

    private PerishablesRepositoryImpl(){
        this.perishables = new HashSet<>();
    }

    private Perishables findPerishables(String perishablesId) {
        return this.perishables.stream()
                .filter(perishables -> perishables.getPerishablesId().trim().equals(perishablesId))
                .findAny()
                .orElse(null);
    }

    public static PerishablesRepositoryImpl getRepository(){
        if (repository == null) repository = new PerishablesRepositoryImpl();
        return repository;
    }


    public Perishables create(Perishables perishables){
        this.perishables.add(perishables);
        return perishables;
    }

    public Perishables read(final String perishablesId){
        Perishables perishables = findPerishables(perishablesId);
        return perishables;
    }

    public void delete(String perishablesId) {
        Perishables perishables = findPerishables(perishablesId);
        if (perishables != null) this.perishables.remove(perishables);
    }

    public Perishables update(Perishables perishables){
        Perishables toDelete = findPerishables(perishables.getPerishablesId());
        if(toDelete != null) {
            this.perishables.remove(toDelete);
            return create(perishables);
        }
        return null;
    }


    public Set<Perishables> getAll(){
        return this.perishables;
    }
}
