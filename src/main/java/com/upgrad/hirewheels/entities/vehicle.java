package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_Id",length = 10)
    private int vehicleId;

    @Column(name="vehicle_model",length = 50,nullable = false)
    private String vehicleModel;

    @Column(name="vehicle_number",length = 10,nullable = false)
    private String vehicleNumber;

    @Column(length = 50,nullable = false)
    private String color;

    @Column(name="availability_status",nullable = false)
    private boolean availabilityStatus;

    @Column(name="vehicle_image_url",length = 500,nullable = false)
    private String vehicleImageUrl;


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getVehicleImageUrl() {
        return vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    @Override
    public String toString(){
        return "Vehicle{"+
                "Vehicle_Id"+vehicleId+'\''+
                "Vehicle_Model"+vehicleModel+'\''+
                "Vehicle_Number"+vehicleNumber+'\''+
                "color"+color+'\''+
                "Availability_Status"+availabilityStatus+'\''+
                "Vehicle_Image_Url"+vehicleImageUrl+'\''+
                "}";
    }
}
