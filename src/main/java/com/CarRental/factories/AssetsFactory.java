package com.CarRental.factories;

import com.CarRental.domain.Assets;

public class AssetsFactory {

    //Changes to be made, in future iteration remove String assetId and have the String assetId generated.
    public static Assets buildAssets(String assetId, String assetName, String assetLocation, String assetType)
    {
        Assets asset = new Assets.Builder()
                .assetId(assetId)
                .assetName(assetName)
                .assetLocation(assetLocation)
                .assetType(assetType)
                .build();
        return asset;
    }
}
