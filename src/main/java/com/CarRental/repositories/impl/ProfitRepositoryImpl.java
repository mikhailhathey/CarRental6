package com.CarRental.repositories.impl;

import com.CarRental.domain.Profit;
import com.CarRental.repositories.ProfitRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProfitRepositoryImpl implements ProfitRepository {

    private static ProfitRepositoryImpl repository = null;
    private Set<Profit> profit;

    private ProfitRepositoryImpl(){
        this.profit = new HashSet<>();
    }

    private Profit findProfit(String profitId) {
        return this.profit.stream()
                .filter(profit -> profit.getProfitId().trim().equals(profitId))
                .findAny()
                .orElse(null);
    }

    public static ProfitRepositoryImpl getRepository(){
        if (repository == null) repository = new ProfitRepositoryImpl();
        return repository;
    }


    public Profit create(Profit profit){
        this.profit.add(profit);
        return profit;
    }

    public Profit read(final String profitId){
        Profit profit = findProfit(profitId);
        return profit;
    }

    public void delete(String profitId) {
        Profit profit = findProfit(profitId);
        if (profit != null) this.profit.remove(profit);
    }

    public Profit update(Profit profit){
        Profit toDelete = findProfit(profit.getProfitId());
        if(toDelete != null) {
            this.profit.remove(toDelete);
            return create(profit);
        }
        return null;
    }


    public Set<Profit> getAll(){
        return this.profit;
    }
}
