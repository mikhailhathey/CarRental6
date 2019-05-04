package com.CarRental.domain;

public class Revenue {

    private String revenueId;
    private String revenueMonth;
    private String revenuePeriod;
    private String revenueAmount;
    private String revenueBranch;

    public String getRevenueId() {
        return revenueId;
    }

    public void setId(String revenueId) {
        this.revenueId = revenueId;
    }

    public String getRevenueMonth() {
        return revenueMonth;
    }

    public void setRevenueMonth(String revenueMonth) {
        this.revenueMonth = revenueMonth;
    }

    public String getRevenuePeriod() {
        return revenuePeriod;
    }

    public void setRevenuePeriod(String revenuePeriod) {
        this.revenuePeriod = revenuePeriod;
    }

    public String getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(String revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    public String getRevenueBranch() {
        return revenueBranch;
    }

    public void setRevenueBranch(String revenueBranch) {
        this.revenueBranch = revenueBranch;
    }

    private Revenue(){

    }

    public Revenue(Builder builder) {
        this.revenueId = builder.revenueId;
        this.revenueMonth = builder.revenueMonth;
        this.revenuePeriod = builder.revenuePeriod;
        this.revenueAmount = builder.revenueAmount;
        this.revenueBranch = builder.revenueBranch;
    }

    public static class Builder{

        private String revenueId;
        private String revenueMonth;
        private String revenuePeriod;
        private String revenueAmount;
        private String revenueBranch;

        public Builder revenueId(String value)
        {
            this.revenueId = value;
            return this;
        }

        public Builder revenueMonth(String value)
        {
            this.revenueMonth = value;
            return this;
        }

        public Builder revenuePeriod(String value)
        {
            this.revenuePeriod = value;
            return this;
        }

        public Builder revenueAmount(String value)
        {
            this.revenueAmount = value;
            return this;
        }

        public Builder revenueBranch(String value)
        {
            this.revenueBranch = value;
            return this;
        }

        public Revenue build(){

            return new Revenue(this);
        }

        public Builder copy(Revenue savedRevenue) {
            this.revenueId = savedRevenue.revenueId;
            this.revenueMonth = savedRevenue.revenueMonth;
            this.revenuePeriod = savedRevenue.revenuePeriod;
            this.revenueAmount = savedRevenue.revenueAmount;
            this.revenueBranch = savedRevenue.revenueBranch;

            return this;
        }
    }
}
