package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Region implements Comparable<Region>{

    @Id
    private String regionId;
    private String regionName;
    private String regionLocation;

    private Region() {
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionLocation() {
        return regionLocation;
    }

    public void setRegionLocation(String regionLocation) {
        this.regionLocation = regionLocation;
    }

    public Region(Builder builder) {
        this.regionId = builder.regionId;
        this.regionName = builder.regionName;
        this.regionLocation = builder.regionLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        Region region = (Region) o;
        return getRegionId().equals(region.getRegionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegionId());
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId='" + regionId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", regionLocation='" + regionLocation + '\'' +
                '}';
    }

    @Override
    public int compareTo(Region region) {
        return this.regionId.compareTo(region.regionId);
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
