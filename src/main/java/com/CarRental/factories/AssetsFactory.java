package com.CarRental.factories;

import com.CarRental.domain.Assets;

public class AssetsFactory {

    //Changes to be made, in future iteration remove String assetId and have the String assetId generated.
    public static Assets buildAssets(String assetsId, String assetsName, String assetsLocation, String assetsType)
    {
        return new Assets.Builder()
                .assetsId(assetsId)
                .assetsName(assetsName)
                .assetsLocation(assetsLocation)
                .assetsType(assetsType)
                .build();
    }
}
