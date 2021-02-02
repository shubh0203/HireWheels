package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class vehicle_category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vehicle_category_id",length = 10)
    private int vehicleCategoryId;

    @Column(name="vehicle_category_name",length = 50,nullable = false,unique = true)
    private String vehicleCategoryName;


    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    @Override
    public String toString(){
        return "vehicle_category {"+
                "Vehicle_category_id="+vehicleCategoryId+'\''+
                "VehicleCategoryName="+vehicleCategoryName+'\''+
        "}";
    }
}
