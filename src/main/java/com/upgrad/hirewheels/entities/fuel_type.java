package com.upgrad.hirewheels.entities;

import javax.persistence.*;


@Entity
public class fuel_type {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fuel_type_id",length=10)
    private int fuelTypeId;

    @Column(name="fuel_type",length = 50,nullable = false,unique = true)
    private String fuelType;

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString(){
        return"fuel_type {"+
                "fuel_type_id="+fuelTypeId+'\''+
                "fuel_type="+fuelType+'\''+
                "}";
    }
}
