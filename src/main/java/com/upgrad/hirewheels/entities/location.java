package com.upgrad.hirewheels.entities;

import javax.persistence.*;


@Entity
public class location {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="loation_Id",length = 10)
    private int locationId;

    @Column(name="loation_name",length = 50,nullable = false)
    private String locationName;

    @Column(name="address",length = 100,nullable = false)
    private String address;

    @Column(name="pincode",length = 6,nullable = false)
    private int pincode;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }


    @Override
    public String toString(){
        return "location {"+
                "location_id"+locationId+'\''+
                "location_name"+locationName+'\''+
                "address"+address+'\''+
                "pincode"+pincode+'\''+
                "}";
    }
}
