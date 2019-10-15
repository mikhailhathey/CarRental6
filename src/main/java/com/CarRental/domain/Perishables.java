package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Perishables implements Comparable<Perishables>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer perishablesId;
    private String perishableName;
    private String perishableExpiryDate;
    private String perishableQuantity;

    private Perishables(){
    }

    public Integer getPerishablesId() {
        return perishablesId;
    }

    public void setPerishablesId(Integer perishablesId) {
        this.perishablesId = perishablesId;
    }

    public String getPerishableName() {
        return perishableName;
    }

    public void setPerishableName(String perishableName) {
        this.perishableName = perishableName;
    }

    public String getPerishableExpiryDate() {
        return perishableExpiryDate;
    }

    public void setPerishableExpiryDate(String perishableExpiryDate) {
        this.perishableExpiryDate = perishableExpiryDate;
    }

    public String getPerishableQuantity() {
        return perishableQuantity;
    }

    public void setPerishableQuantity(String perishableQuantity) {
        this.perishableQuantity = perishableQuantity;
    }

    public Perishables(Builder builder) {
        this.perishablesId = builder.perishablesId;
        this.perishableName = builder.perishableName;
        this.perishableExpiryDate = builder.perishableExpiryDate;
        this.perishableQuantity = builder.perishableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perishables)) return false;
        Perishables perishables = (Perishables) o;
        return getPerishablesId().equals(perishables.getPerishablesId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerishablesId());
    }

    @Override
    public String toString() {
        return "Perishables{" +
                "perishablesId='" + perishablesId + '\'' +
                ", perishableName='" + perishableName + '\'' +
                ", perishableExpiryDate='" + perishableExpiryDate + '\'' +
                ", perishableQuantity='" + perishableQuantity + '\'' +
                '}';
    }

    @Override
    public int compareTo(Perishables perishables) {
        return this.perishablesId.compareTo(perishables.perishablesId);
    }

    public static class Builder{

        private Integer perishablesId;
        private String perishableName;
        private String perishableExpiryDate;
        private String perishableQuantity;

        public Builder perishablesId(Integer value)
        {
            this.perishablesId = value;
            return this;
        }

        public Builder perishableName(String value)
        {
            this.perishableName = value;
            return this;
        }

        public Builder perishableExpiryDate(String value)
        {
            this.perishableExpiryDate = value;
            return this;
        }

        public Builder perishableQuantity(String value)
        {
            this.perishableQuantity = value;
            return this;
        }

        public Perishables build(){

            return new Perishables(this);
        }

        public Builder copy(Perishables savedPerishables) {
            this.perishablesId = savedPerishables.perishablesId;
            this.perishableName = savedPerishables.perishableName;
            this.perishableExpiryDate = savedPerishables.perishableExpiryDate;
            this.perishableQuantity = savedPerishables.perishableQuantity;

            return this;
        }
    }
}
