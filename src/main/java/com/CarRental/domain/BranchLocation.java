package com.CarRental.domain;

public class BranchLocation {

    private String branchLocationId;
    private String branchName;
    private String branchManager;

    public String getbranchLocationId() {
        return branchLocationId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchManager() {
        return branchManager;
    }

    private BranchLocation() {
    }

    public BranchLocation(Builder builder) {
        this.branchLocationId = builder.branchLocationId;
        this.branchName = builder.branchName;
        this.branchManager = builder.branchManager;
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

    }
}
