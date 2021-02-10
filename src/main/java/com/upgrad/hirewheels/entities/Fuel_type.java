package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Fuel_type {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fuel_type_id",length=10)
    private int fuelTypeId;

    @Column(name="fuel_type",length = 50,nullable = false,unique = true)
    private String fuelType;

    @OneToMany (mappedBy = "fuel_Type", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Fuel_type() {
    }

    public Fuel_type(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;

    }


    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

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
