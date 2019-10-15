package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hardware implements Comparable<Hardware>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer hardwareId;
    private String hardwareName;
    private String hardwarePrice;

    private Hardware(){
    }

    public Integer getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(Integer hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getHardwareName() {
        return hardwareName;
    }

    public void setHardwareName(String hardwareName) {
        this.hardwareName = hardwareName;
    }

    public String getHardwarePrice() {
        return hardwarePrice;
    }

    public void setHardwarePrice(String hardwarePrice) {
        this.hardwarePrice = hardwarePrice;
    }

    public Hardware(Builder builder) {
        this.hardwareId = builder.hardwareId;
        this.hardwareName = builder.hardwareName;
        this.hardwarePrice = builder.hardwarePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hardware)) return false;
        Hardware hardware = (Hardware) o;
        return getHardwareId().equals(hardware.getHardwareId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHardwareId());
    }

    @Override
    public String toString() {
        return "Hardware{" +
                "hardwareId='" + hardwareId + '\'' +
                ", hardwareName='" + hardwareName + '\'' +
                ", hardwarePrice='" + hardwarePrice + '\'' +
                '}';
    }

    @Override
    public int compareTo(Hardware hardware) {
        return this.hardwareId.compareTo(hardware.hardwareId);
    }

    public static class Builder{

        private Integer hardwareId;
        private String hardwareName;
        private String hardwarePrice;

        public Builder hardwareId(Integer value)
        {
            this.hardwareId = value;
            return this;
        }

        public Builder hardwareName(String value)
        {
            this.hardwareName = value;
            return this;
        }

        public Builder hardwarePrice(String value)
        {
            this.hardwarePrice = value;
            return this;
        }

        public Hardware build(){

            return new Hardware(this);
        }

        public Builder copy(Hardware savedHardware) {
            this.hardwareId = savedHardware.hardwareId;
            this.hardwareName = savedHardware.hardwareName;
            this.hardwarePrice = savedHardware.hardwarePrice;

            return this;
        }
    }
}
