package com.CarRental.domain;

public class Assets {


    private String assetsId;
    private String assetsName;
    private String assetsLocation;
    private String assetsType;

    public String getAssetsId() {
        return assetsId;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public String getAssetsLocation() {
        return assetsLocation;
    }

    public String getAssetsType() {
        return assetsType;
    }

    private Assets() {
    }

    public Assets(Builder builder) {
        this.assetsId = builder.assetsId;
        this.assetsName = builder.assetsName;
        this.assetsLocation = builder.assetsLocation;
        this.assetsType = builder.assetsType;
    }

    public static class Builder{

        private String assetsId;
        private String assetsName;
        private String assetsLocation;
        private String assetsType;

        public Builder assetsId(String value){
            this.assetsId = value;
            return this;
        }

        public Builder assetsName(String value){
            this.assetsName = value;
            return this;
        }

        public Builder assetsLocation(String value){
            this.assetsLocation = value;
            return this;
        }

        public Builder assetsType(String value){
            this.assetsType = value;
            return this;
        }

        public Assets build(){

            return new Assets(this);
        }

        public Builder copy(Assets savedAssets) {
            this.assetsId = savedAssets.assetsId;
            this.assetsName = savedAssets.assetsName;
            this.assetsLocation = savedAssets.assetsLocation;
            this.assetsType = savedAssets.assetsType;

            return this;
        }
    }
}
