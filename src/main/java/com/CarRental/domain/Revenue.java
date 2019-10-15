package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Revenue implements Comparable<Revenue>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer revenueId;
    private String revenueMonth;
    private String revenuePeriod;
    private String revenueAmount;
    private String revenueBranch;

    private Revenue(){
    }

    public Integer getRevenueId() {
        return revenueId;
    }

    public void setRevenueId(Integer revenueId) {
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


    public Revenue(Builder builder) {
        this.revenueId = builder.revenueId;
        this.revenueMonth = builder.revenueMonth;
        this.revenuePeriod = builder.revenuePeriod;
        this.revenueAmount = builder.revenueAmount;
        this.revenueBranch = builder.revenueBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Revenue)) return false;
        Revenue revenue = (Revenue) o;
        return getRevenueId().equals(revenue.getRevenueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRevenueId());
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "revenueId='" + revenueId + '\'' +
                ", revenueMonth='" + revenueMonth + '\'' +
                ", revenuePeriod='" + revenuePeriod + '\'' +
                ", revenueAmount='" + revenueAmount + '\'' +
                ", revenueBranch='" + revenueBranch + '\'' +
                '}';
    }

    @Override
    public int compareTo(Revenue revenue) {
        return this.revenueId.compareTo(revenue.revenueId);
    }

    public static class Builder{

        private Integer revenueId;
        private String revenueMonth;
        private String revenuePeriod;
        private String revenueAmount;
        private String revenueBranch;

        public Builder revenueId(Integer value)
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
