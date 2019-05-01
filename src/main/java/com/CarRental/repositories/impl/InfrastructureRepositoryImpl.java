package com.CarRental.repositories.impl;

import com.CarRental.domain.Infrastructure;
import com.CarRental.repositories.InfrastructureRepository;

import java.util.HashSet;
import java.util.Set;

public class InfrastructureRepositoryImpl implements InfrastructureRepository {

    private static InfrastructureRepositoryImpl repository = null;
    private Set<Infrastructure> infrastructure;

    private InfrastructureRepositoryImpl(){
        this.infrastructure = new HashSet<>();
    }

    private Infrastructure findInfrastructure(String infrastructureId) {
        return this.infrastructure.stream()
                .filter(infrastructure -> infrastructure.getInfrastructureId().trim().equals(infrastructureId))
                .findAny()
                .orElse(null);
    }

    public static InfrastructureRepositoryImpl getRepository(){
        if (repository == null) repository = new InfrastructureRepositoryImpl();
        return repository;
    }


    public Infrastructure create(Infrastructure infrastructure){
        this.infrastructure.add(infrastructure);
        return infrastructure;
    }

    public Infrastructure read(final String infrastructureId){
        Infrastructure infrastructure = findInfrastructure(infrastructureId);
        return infrastructure;
    }

    public void delete(String infrastructureId) {
        Infrastructure infrastructure = findInfrastructure(infrastructureId);
        if (infrastructure != null) this.infrastructure.remove(infrastructure);
    }

    public Infrastructure update(Infrastructure infrastructure){
        Infrastructure toDelete = findInfrastructure(infrastructure.getInfrastructureId());
        if(toDelete != null) {
            this.infrastructure.remove(toDelete);
            return create(infrastructure);
        }
        return null;
    }


    public Set<Infrastructure> getAll(){
        return this.infrastructure;
    }
}
