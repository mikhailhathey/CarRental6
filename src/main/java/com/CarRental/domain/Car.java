package com.CarRental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car implements Comparable<Car>{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer carId;
    private String vinNumber;
    private String manufacturerName;
    private String modelName;
    private String yearModel;

    private Car(){
    }

    public Car(Builder builder) {
        this.carId = builder.carId;
        this.vinNumber = builder.vinNumber;
        this.manufacturerName = builder.manufacturerName;
        this.modelName = builder.modelName;
        this.yearModel = builder.yearModel;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getYearModel() {
        return yearModel;
    }

    public void setYearModel(String yearModel) {
        this.yearModel = yearModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCarId().equals(car.getCarId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", yearModel='" + yearModel + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        return this.carId.compareTo(car.carId);
    }

    public static class Builder{

        private Integer carId;
        private String vinNumber;
        private String manufacturerName;
        private String modelName;
        private String yearModel;

        public Builder carId(Integer value)
        {
            this.carId = value;
            return this;
        }

        public Builder vinNumber(String value)
        {
            this.vinNumber = value;
            return this;
        }

        public Builder manufacturerName(String value)
        {
            this.manufacturerName = value;
            return this;
        }

        public Builder modelName(String value)
        {
            this.modelName = value;
            return this;
        }

        public Builder yearModel(String value)
        {
            this.yearModel = value;
            return this;
        }

        public Car build(){

            return new Car(this);
        }

        public Builder copy(Car savedCar) {
            this.carId = savedCar.carId;
            this.vinNumber = savedCar.vinNumber;
            this.manufacturerName = savedCar.manufacturerName;
            this.modelName = savedCar.modelName;
            this.yearModel = savedCar.yearModel;

            return this;
        }
    }
}
