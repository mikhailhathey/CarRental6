package com.CarRental.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address implements Comparable<Address> {

/*    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="address_id")*/
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer addressId;
    private String houseNumber;
    private String streetName;
    private String suburb;
    private String postalCode;
    private String city;

    private Address(){
    }

    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.houseNumber = builder.houseNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Column(name = "house_number", nullable = false)
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Column(name = "street", nullable = false)
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Column(name = "suburb", nullable = false)
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Column(name = "postal_code", nullable = false)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getAddressId().equals(address.getAddressId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int compareTo(Address address) {
        return this.addressId.compareTo(address.addressId);
    }

    public static class Builder{

        private Integer addressId;
        private String houseNumber;
        private String streetName;
        private String suburb;
        private String postalCode;
        private String city;

        public Builder addressId(Integer value)
        {
            this.addressId = value;
            return this;
        }

        public Builder houseNumber(String value)
        {
            this.houseNumber = value;
            return this;
        }

        public Builder streetName(String value)
        {
            this.streetName = value;
            return this;
        }

        public Builder suburb(String value)
        {
            this.suburb = value;
            return this;
        }

        public Builder postalCode(String value)
        {
            this.postalCode = value;
            return this;
        }

        public Builder city(String value)
        {
            this.city = value;
            return this;
        }

        public Address build(){
            return new Address(this);
        }

        public Builder copy(Address savedAddress) {
            this.addressId = savedAddress.addressId;
            this.addressId = savedAddress.addressId;
            this.houseNumber = savedAddress.houseNumber;
            this.streetName = savedAddress.streetName;
            this.suburb = savedAddress.suburb;
            this.postalCode = savedAddress.postalCode;
            this.city = savedAddress.city;

            return this;
        }
    }
}
