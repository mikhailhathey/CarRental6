package com.CarRental.domain;

public class Claims {


    private String claimsId;
    private String claimProvider;
    private String claimValue;
    private String claimReason;

    public String getClaimsId() {
        return claimsId;
    }

    public String getClaimProvider() {
        return claimProvider;
    }

    public String getClaimValue() {
        return claimValue;
    }

    public String getClaimReason() {
        return claimReason;
    }

    private Claims() {
    }

    public Claims(Builder builder) {
        this.claimsId = builder.claimsId;
        this.claimProvider = builder.claimProvider;
        this.claimValue = builder.claimValue;
        this.claimReason = builder.claimReason;
    }

    public static class Builder{

        private String claimsId;
        private String claimProvider;
        private String claimValue;
        private String claimReason;

        public Builder claimsId(String value){
            this.claimsId = value;
            return this;
        }

        public Builder claimProvider(String value){
            this.claimProvider = value;
            return this;
        }

        public Builder claimValue(String value){
            this.claimValue = value;
            return this;
        }

        public Builder claimReason(String value){
            this.claimReason = value;
            return this;
        }

        public Claims build(){

            return new Claims(this);
        }

    }
}
