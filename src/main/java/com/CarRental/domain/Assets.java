package com.CarRental.domain;

public class Assets {


    private String assetAssetId;
    private String assetName;
    private String assetLocation;
    private String assetType;

    public String getAssetId() {
        return assetAssetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetLocation() {
        return assetLocation;
    }

    public String getAssetType() {
        return assetType;
    }

    private Contact() {
    }

    public Contact(Builder builder) {
        this.assetAssetId = builder.assetAssetId;
        this.assetName = builder.assetName;
        this.assetLocation = builder.assetLocation;
        this.assetType = builder.assetType;
    }

    public static class Builder{

        private String assetAssetId;
        private String assetName;
        private String assetLocation;
        private String assetType;

        public Builder assetAssetId(String value){
            this.assetAssetId = value;
            return this;
        }

        public Builder assetName(String value){
            this.assetName = value;
            return this;
        }

        public Builder assetLocation(String value){
            this.assetLocation = value;
            return this;
        }

        public Builder assetType(String value){
            this.assetType = value;
            return this;
        }

        public Contact build(){

            return new Contact(this);
        }

    }
}
