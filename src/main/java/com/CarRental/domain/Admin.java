package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Admin implements Comparable<Admin>{

    @Id
    private String adminId;
    private String adminName;
    private String adminPassword;

    private Admin() {
    }


    public Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.adminName = builder.adminName;
        this.adminPassword = builder.adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return getAdminId().equals(admin.getAdminId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminId());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    @Override
    public int compareTo(Admin admin) {
        return this.adminId.compareTo(admin.adminId);
    }

    public static class Builder{
        private String adminId;
        private String adminName;
        private String adminPassword;

        public Builder adminId(String value){
            this.adminId = value;
            return this;
        }

        public Builder adminName(String value){
            this.adminName = value;
            return this;
        }

        public Builder adminPassword(String value){
            this.adminPassword = value;
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }

        public Builder copy(Admin savedAdmin) {
            this.adminId = savedAdmin.adminId;
            this.adminName = savedAdmin.adminName;
            this.adminPassword = savedAdmin.adminPassword;

            return this;
        }
    }
}
