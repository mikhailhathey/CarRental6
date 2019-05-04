package com.CarRental.domain;

public class Profit {

    private String profitId;
    private String profitProjected;
    private String profitActual;

    public String getProfitId() {
        return profitId;
    }

    public String getProfitProjected() {
        return profitProjected;
    }

    public String getProfitActual() {
        return profitActual;
    }

    private Profit() {
    }

    public Profit(Builder builder) {
        this.profitId = builder.profitId;
        this.profitProjected = builder.profitProjected;
        this.profitActual = builder.profitActual;
    }

    public static class Builder{
        private String profitId;
        private String profitProjected;
        private String profitActual;

        public Builder profitId(String value){
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
