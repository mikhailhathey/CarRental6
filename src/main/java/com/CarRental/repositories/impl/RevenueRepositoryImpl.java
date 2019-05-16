package com.CarRental.repositories.impl;

import com.CarRental.domain.Revenue;
import com.CarRental.repositories.RevenueRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RevenueRepositoryImpl implements RevenueRepository {

    private static RevenueRepositoryImpl repository = null;
    private Set<Revenue> revenue;

    private RevenueRepositoryImpl(){
        this.revenue = new HashSet<>();
    }

    private Revenue findRevenue(String revenueId) {
        return this.revenue.stream()
                .filter(revenue -> revenue.getRevenueId().trim().equals(revenueId))
                .findAny()
                .orElse(null);
    }

    public static RevenueRepositoryImpl getRepository(){
        if (repository == null) repository = new RevenueRepositoryImpl();
        return repository;
    }


    public Revenue create(Revenue revenue){
        this.revenue.add(revenue);
        return revenue;
    }

    public Revenue read(final String revenueId){
        Revenue revenue = findRevenue(revenueId);
        return revenue;
    }

    public void delete(String revenueId) {
        Revenue revenue = findRevenue(revenueId);
        if (revenue != null) this.revenue.remove(revenue);
    }

    public Revenue update(Revenue revenue){
        Revenue toDelete = findRevenue(revenue.getRevenueId());
        if(toDelete != null) {
            this.revenue.remove(toDelete);
            return create(revenue);
        }
        return null;
    }


    public Set<Revenue> getAll(){
        return this.revenue;
    }
}
