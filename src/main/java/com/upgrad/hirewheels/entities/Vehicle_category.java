package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle_category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vehicle_category_id",length = 10)
    private int vehicleCategoryId;

    @Column(name="vehicle_category_name",length = 50,nullable = false,unique = true)
    private String vehicleCategoryName;

    @OneToMany (mappedBy = "vehicleCategory", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Vehicle_subcategory> vehicleSubcategories;

    public Vehicle_category() {
    }

    public Vehicle_category(int vehicleCategoryId, String vehicleCategoryName) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public Set<Vehicle_subcategory> getVehicleSubcategories() {
        return vehicleSubcategories;
    }

    public void setVehicleSubcategories(Set<Vehicle_subcategory> vehicleSubcategories) {
        this.vehicleSubcategories = vehicleSubcategories;
    }


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
