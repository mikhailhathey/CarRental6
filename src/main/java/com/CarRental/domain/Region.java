package com.CarRental.domain;

public class Region {

    private String regionId;
    private String regionName;
    private String regionLocation;

    public String getRegionId() {
        return regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getRegionLocation() {
        return regionLocation;
    }

    private Region() {
    }

    public Region(Builder builder) {
        this.regionId = builder.regionId;
        this.regionName = builder.regionName;
        this.regionLocation = builder.regionLocation;
    }

    public static class Builder{
        private String regionId;
        private String regionName;
        private String regionLocation;

        public Builder regionId(String value){
            this.regionId = value;
            return this;
        }

        public Builder regionName(String value){
            this.regionName = value;
            return this;
        }

        public Builder regionLocation(String value){
            this.regionLocation = value;
            return this;
        }

        public Region build(){

            return new Region(this);
        }

        public Builder copy(Region savedRegion) {
            this.regionId = savedRegion.regionId;
            this.regionName = savedRegion.regionName;
            this.regionLocation = savedRegion.regionLocation;

            return this;
        }
    }
}
