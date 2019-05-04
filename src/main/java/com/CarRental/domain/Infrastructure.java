package com.CarRental.domain;

public class Infrastructure {

    private String infrastructureId;
    private String infrastructureVendor;
    private String infrastructureName;
    private String infrastructureCost;

    public String getInfrastructureId() {
        return infrastructureId;
    }

    public void setInfrastructureId(String infrastructureId) {
        this.infrastructureId = infrastructureId;
    }

    public String getInfrastructureVendor() {
        return infrastructureVendor;
    }

    public void setInfrastructureVendor(String infrastructureVendor) {
        this.infrastructureVendor = infrastructureVendor;
    }

    public String getInfrastructureName() {
        return infrastructureName;
    }

    public void setInfrastructureName(String infrastructureName) {
        this.infrastructureName = infrastructureName;
    }

    public String getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(String infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    private Infrastructure(){

    }

    public Infrastructure(Builder builder) {
        this.infrastructureId = builder.infrastructureId;
        this.infrastructureVendor = builder.infrastructureVendor;
        this.infrastructureName = builder.infrastructureName;
        this.infrastructureCost = builder.infrastructureCost;
    }

    public static class Builder{

        private String infrastructureId;
        private String infrastructureVendor;
        private String infrastructureName;
        private String infrastructureCost;

        public Builder infrastructureId(String value)
        {
            this.infrastructureId = value;
            return this;
        }

        public Builder infrastructureVendor(String value)
        {
            this.infrastructureVendor = value;
            return this;
        }

        public Builder infrastructureName(String value)
        {
            this.infrastructureName = value;
            return this;
        }

        public Builder infrastructureCost(String value)
        {
            this.infrastructureCost = value;
            return this;
        }

        public Infrastructure build(){

            return new Infrastructure(this);
        }

        public Builder copy(Infrastructure savedInfrastructure) {
            this.infrastructureId = savedInfrastructure.infrastructureId;
            this.infrastructureVendor = savedInfrastructure.infrastructureVendor;
            this.infrastructureName = savedInfrastructure.infrastructureName;
            this.infrastructureCost = savedInfrastructure.infrastructureCost;

            return this;
        }
    }
}
