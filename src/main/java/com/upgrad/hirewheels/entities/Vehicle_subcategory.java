package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Vehicle_subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vehicle_subcategory_id",length = 10)
    private int vehicleSubcategoryId;

    @Column(name="vehicle_subcategory_name",length = 50,nullable = false,unique = true)
    private String vehicleSubcategoryName;

    @Column(name="price_per_day",length = 10,nullable = false)
    private double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = false)
    private Vehicle_category vehicleCategory;

    @OneToMany (mappedBy = "vehicleSubcategory", fetch = FetchType.EAGER,cascade =  {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle_category getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(Vehicle_category vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString(){
        return "vehicle_subcategory {"+
                "vehicle_subcategory_id="+vehicleSubcategoryId+'\''+
                "vehicle_subcategory_name="+vehicleSubcategoryName+'\''+
                "price_per_day"+pricePerDay+'\''+
                ", vehicleCategory="+vehicleCategory+'\''+
                "}";
    }
}
