package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Assets implements Comparable<Assets> {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer assetsId;
    private String assetsName;
    private String assetsLocation;
    private String assetsType;

    private Assets() {
    }

    public Assets(Builder builder) {
        this.assetsId = builder.assetsId;
        this.assetsName = builder.assetsName;
        this.assetsLocation = builder.assetsLocation;
        this.assetsType = builder.assetsType;
    }

    public Integer getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Integer assetsId) {
        this.assetsId = assetsId;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetsLocation() {
        return assetsLocation;
    }

    public void setAssetsLocation(String assetsLocation) {
        this.assetsLocation = assetsLocation;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assets)) return false;
        Assets assets = (Assets) o;
        return getAssetsId().equals(assets.getAssetsId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssetsId());
    }

    @Override
    public String toString() {
        return "Assets{" +
                "assetsId='" + assetsId + '\'' +
                ", assetsName='" + assetsName + '\'' +
                ", assetsLocation='" + assetsLocation + '\'' +
                ", assetsType='" + assetsType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Assets assets) {
        return this.assetsId.compareTo(assets.assetsId);
    }

    public static class Builder{

        private Integer assetsId;
        private String assetsName;
        private String assetsLocation;
        private String assetsType;

        public Builder assetsId(Integer value){
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
