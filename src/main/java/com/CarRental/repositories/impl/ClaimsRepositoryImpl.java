package com.CarRental.repositories.impl;

import com.CarRental.domain.Claims;
import com.CarRental.repositories.ClaimsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ClaimsRepositoryImpl implements ClaimsRepository {

    private static ClaimsRepositoryImpl repository = null;
    private Set<Claims> claims;

    private ClaimsRepositoryImpl(){
        this.claims = new HashSet<>();
    }

    private Claims findClaims(String claimsId) {
        return this.claims.stream()
                .filter(claims -> claims.getClaimsId().trim().equals(claimsId))
                .findAny()
                .orElse(null);
    }

    public static ClaimsRepositoryImpl getRepository(){
        if (repository == null) repository = new ClaimsRepositoryImpl();
        return repository;
    }


    public Claims create(Claims claims){
        this.claims.add(claims);
        return claims;
    }

    public Claims read(final String claimsId){
        Claims claims = findClaims(claimsId);
        return claims;
    }

    public void delete(String claimsId) {
        Claims claims = findClaims(claimsId);
        if (claims != null) this.claims.remove(claims);
    }

    public Claims update(Claims claims){
        Claims toDelete = findClaims(claims.getClaimsId());
        if(toDelete != null) {
            this.claims.remove(toDelete);
            return create(claims);
        }
        return null;
    }


    public Set<Claims> getAll(){
        return this.claims;
    }
}
