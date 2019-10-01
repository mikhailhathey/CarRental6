package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Claims implements Comparable<Claims> {

    @Id
    private String claimsId;
    private String claimProvider;
    private String claimValue;
    private String claimReason;

    private Claims() {
    }

    public String getClaimsId() {
        return claimsId;
    }

    public void setClaimsId(String claimsId) {
        this.claimsId = claimsId;
    }

    public String getClaimProvider() {
        return claimProvider;
    }

    public void setClaimProvider(String claimProvider) {
        this.claimProvider = claimProvider;
    }

    public String getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(String claimValue) {
        this.claimValue = claimValue;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Claims)) return false;
        Claims claims = (Claims) o;
        return getClaimsId().equals(claims.getClaimsId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClaimsId());
    }

    @Override
    public String toString() {
        return "Claims{" +
                "claimsId='" + claimsId + '\'' +
                ", claimProvider='" + claimProvider + '\'' +
                ", claimValue='" + claimValue + '\'' +
                ", claimReason='" + claimReason + '\'' +
                '}';
    }

    @Override
    public int compareTo(Claims claims) {
        return this.claimsId.compareTo(claims.claimsId);
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

        public Builder copy(Claims savedClaims) {
            this.claimsId = savedClaims.claimsId;
            this.claimProvider = savedClaims.claimProvider;
            this.claimValue = savedClaims.claimValue;
            this.claimReason = savedClaims.claimReason;

            return this;
        }
    }
}
