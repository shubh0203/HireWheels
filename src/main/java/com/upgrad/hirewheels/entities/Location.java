package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="location_id")
    private int locationId;

    @Column(name="loation_name",length = 50,nullable = false)
    private String locationName;

    @Column(name="location_address",length = 100,nullable = false)
    private String locationAddress;

    @Column(length = 6,nullable = false)
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany (mappedBy = "location", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Booking> bookings;

    @OneToMany (mappedBy = "location", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }



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

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString(){
        return "location {"+
                "location_id"+locationId+'\''+
                "location_name"+locationName+'\''+
                "address"+locationAddress+'\''+
                "pincode"+pincode+'\''+
                ",city="+city +'\''+
                "}";
    }
}
