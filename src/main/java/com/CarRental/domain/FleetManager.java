package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class FleetManager implements Comparable<FleetManager>{

    @Id
    private String fleetManagerId;
    private String fleetManagerNumber;
    private String fleetManagerClass;
    private String fleetManagerDays;
    private String fleetManagerContact;
    private String fleetManagerBranch;

    private FleetManager(){
    }

    //fleetManagerId, fleetManagerNumber, fleetManagerClass, fleetManagerDays, fleetManagerContact, fleetManagerBranch
    public String getFleetManagerId() {
        return fleetManagerId;
    }

    public void setFleetManagerId(String fleetManagerId) {
        this.fleetManagerId = fleetManagerId;
    }

    public String getFleetManagerNumber() {
        return fleetManagerNumber;
    }

    public void setFleetManagerNumber(String fleetManagerNumber) {
        this.fleetManagerNumber = fleetManagerNumber;
    }

    public String getFleetManagerClass() {
        return fleetManagerClass;
    }

    public void setFleetManagerClass(String fleetManagerClass) {
        this.fleetManagerClass = fleetManagerClass;
    }

    public String getFleetManagerDays() {
        return fleetManagerDays;
    }

    public void setFleetManagerDays(String fleetManagerDays) {
        this.fleetManagerDays = fleetManagerDays;
    }

    public String getFleetManagerContact() {
        return fleetManagerContact;
    }

    public void setFleetManagerContact(String fleetManagerContact) {
        this.fleetManagerContact = fleetManagerContact;
    }

    public String getFleetManagerBranch() {
        return fleetManagerBranch;
    }

    public void setFleetManagerBranch(String fleetManagerBranch) {
        this.fleetManagerBranch = fleetManagerBranch;
    }

    public FleetManager(Builder builder) {
        this.fleetManagerId = builder.fleetManagerId;
        this.fleetManagerNumber = builder.fleetManagerNumber;
        this.fleetManagerClass = builder.fleetManagerClass;
        this.fleetManagerDays = builder.fleetManagerDays;
        this.fleetManagerContact = builder.fleetManagerContact;
        this.fleetManagerBranch = builder.fleetManagerBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FleetManager)) return false;
        FleetManager fleetManager = (FleetManager) o;
        return getFleetManagerId().equals(fleetManager.getFleetManagerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFleetManagerId());
    }

    @Override
    public String toString() {
        return "FleetManager{" +
                "fleetManagerId='" + fleetManagerId + '\'' +
                ", fleetManagerNumber='" + fleetManagerNumber + '\'' +
                ", fleetManagerClass='" + fleetManagerClass + '\'' +
                ", fleetManagerDays='" + fleetManagerDays + '\'' +
                ", fleetManagerContact='" + fleetManagerContact + '\'' +
                ", fleetManagerBranch='" + fleetManagerBranch + '\'' +
                '}';
    }

    @Override
    public int compareTo(FleetManager fleetManager) {
        return this.fleetManagerId.compareTo(fleetManager.fleetManagerId);
    }

    public static class Builder{

        private String fleetManagerId;
        private String fleetManagerNumber;
        private String fleetManagerClass;
        private String fleetManagerDays;
        private String fleetManagerContact;
        private String fleetManagerBranch;

        public Builder fleetManagerId(String value)
        {
            this.fleetManagerId = value;
            return this;
        }

        public Builder fleetManagerNumber(String value)
        {
            this.fleetManagerNumber = value;
            return this;
        }

        public Builder fleetManagerClass(String value)
        {
            this.fleetManagerClass = value;
            return this;
        }

        public Builder fleetManagerDays(String value)
        {
            this.fleetManagerDays = value;
            return this;
        }

        public Builder fleetManagerContact(String value)
        {
            this.fleetManagerContact = value;
            return this;
        }

        public Builder fleetManagerBranch(String value)
        {
            this.fleetManagerBranch = value;
            return this;
        }

        public FleetManager build(){

            return new FleetManager(this);
        }

        public Builder copy(FleetManager savedFleetManager) {
            this.fleetManagerId = savedFleetManager.fleetManagerId;
            this.fleetManagerNumber = savedFleetManager.fleetManagerNumber;
            this.fleetManagerClass = savedFleetManager.fleetManagerClass;
            this.fleetManagerDays = savedFleetManager.fleetManagerDays;
            this.fleetManagerContact = savedFleetManager.fleetManagerContact;
            this.fleetManagerBranch = savedFleetManager.fleetManagerBranch;

            return this;
        }
    }
}
