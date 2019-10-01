package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BranchLocation implements Comparable<BranchLocation> {

    @Id
    private String branchLocationId;
    private String branchName;
    private String branchManager;

    private BranchLocation() {
    }

    public BranchLocation(Builder builder) {
        this.branchLocationId = builder.branchLocationId;
        this.branchName = builder.branchName;
        this.branchManager = builder.branchManager;
    }

    public String getBranchLocationId() {
        return branchLocationId;
    }

    public void setBranchLocationId(String branchLocationId) {
        this.branchLocationId = branchLocationId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(String branchManager) {
        this.branchManager = branchManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BranchLocation)) return false;
        BranchLocation branchLocation = (BranchLocation) o;
        return getBranchLocationId().equals(branchLocation.getBranchLocationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBranchLocationId());
    }

    @Override
    public String toString() {
        return "BranchLocation{" +
                "branchLocationId='" + branchLocationId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", branchManager='" + branchManager + '\'' +
                '}';
    }

    @Override
    public int compareTo(BranchLocation branchLocation) {
        return this.branchLocationId.compareTo(branchLocation.branchLocationId);
    }

    public static class Builder{
        private String branchLocationId;
        private String branchName;
        private String branchManager;

        public Builder branchLocationId(String value){
            this.branchLocationId = value;
            return this;
        }

        public Builder branchName(String value){
            this.branchName = value;
            return this;
        }

        public Builder branchManager(String value){
            this.branchManager = value;
            return this;
        }

        public BranchLocation build(){

            return new BranchLocation(this);
        }

        public Builder copy(BranchLocation savedBranchLocation) {
            this.branchLocationId = savedBranchLocation.branchLocationId;
            this.branchName = savedBranchLocation.branchName;
            this.branchManager = savedBranchLocation.branchManager;

            return this;
        }
    }
}
