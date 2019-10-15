package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Profit implements Comparable<Profit>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer profitId;
    private String profitProjected;
    private String profitActual;

    private Profit() {
    }

    public Integer getProfitId() {
        return profitId;
    }

    public void setProfitId(Integer profitId) {
        this.profitId = profitId;
    }

    public String getProfitProjected() {
        return profitProjected;
    }
    
    public void setProfitProjected(String profitProjected) {
        this.profitProjected = profitProjected;
    }

    public String getProfitActual() {
        return profitActual;
    }
    
    public void setProfitActual(String profitActual) {
        this.profitActual = profitActual;
    }

    public Profit(Builder builder) {
        this.profitId = builder.profitId;
        this.profitProjected = builder.profitProjected;
        this.profitActual = builder.profitActual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profit)) return false;
        Profit profit = (Profit) o;
        return getProfitId().equals(profit.getProfitId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfitId());
    }

    @Override
    public String toString() {
        return "Profit{" +
                "profitId='" + profitId + '\'' +
                ", profitProjected='" + profitProjected + '\'' +
                ", profitActual='" + profitActual + '\'' +
                '}';
    }

    @Override
    public int compareTo(Profit profit) {
        return this.profitId.compareTo(profit.profitId);
    }

    public static class Builder{
        private Integer profitId;
        private String profitProjected;
        private String profitActual;

        public Builder profitId(Integer value){
            this.profitId = value;
            return this;
        }

        public Builder profitProjected(String value){
            this.profitProjected = value;
            return this;
        }

        public Builder profitActual(String value){
            this.profitActual = value;
            return this;
        }

        public Profit build(){

            return new Profit(this);
        }

        public Builder copy(Profit savedProfit) {
            this.profitId = savedProfit.profitId;
            this.profitProjected = savedProfit.profitProjected;
            this.profitActual = savedProfit.profitActual;

            return this;
        }
    }
}
