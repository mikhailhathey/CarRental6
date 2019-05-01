package com.CarRental.domain;

public class Assets {


    private String assetId;
    private String assetName;
    private String assetLocation;
    private String assetType;

    public String getAssetId() {
        return assetId;
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

    private Assets() {
    }

    public Assets(Builder builder) {
        this.assetId = builder.assetId;
        this.assetName = builder.assetName;
        this.assetLocation = builder.assetLocation;
        this.assetType = builder.assetType;
    }

    public static class Builder{

        private String assetId;
        private String assetName;
        private String assetLocation;
        private String assetType;

        public Builder assetId(String value){
            this.assetId = value;
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

        public Assets build(){

            return new Assets(this);
        }

    }
}
