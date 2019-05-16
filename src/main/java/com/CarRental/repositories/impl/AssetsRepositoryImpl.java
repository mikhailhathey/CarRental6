package com.CarRental.repositories.impl;

import com.CarRental.domain.Assets;
import com.CarRental.repositories.AssetsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class AssetsRepositoryImpl implements AssetsRepository {

    private static AssetsRepositoryImpl repository = null;
    private Set<Assets> assets;

    private AssetsRepositoryImpl(){
        this.assets = new HashSet<>();
    }

    private Assets findAssets(String assetsId) {
        return this.assets.stream()
                .filter(assets -> assets.getAssetsId().trim().equals(assetsId))
                .findAny()
                .orElse(null);
    }

    public static AssetsRepositoryImpl getRepository(){
        if (repository == null) repository = new AssetsRepositoryImpl();
        return repository;
    }


    public Assets create(Assets assets){
        this.assets.add(assets);
        return assets;
    }

    public Assets read(final String assetsId){
        Assets assets = findAssets(assetsId);
        return assets;
    }

    public void delete(String assetsId) {
        Assets assets = findAssets(assetsId);
        if (assets != null) this.assets.remove(assets);
    }

    public Assets update(Assets assets){
        Assets toDelete = findAssets(assets.getAssetsId());
        if(toDelete != null) {
            this.assets.remove(toDelete);
            return create(assets);
        }
        return null;
    }


    public Set<Assets> getAll(){
        return this.assets;
    }
}
