package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleDao vehicleDao;

    @Autowired
    Vehicle_categoryDao vehicleCategoryDao;

    @Autowired
    Vehicle_subcategoryDao vehicleSubcategoryDao;

    @Autowired
    BookingDao bookingDao;

    @Override
    public List<Vehicle> getAllVehicles(){
        return vehicleDao.findAll();
    }

    public Set<Vehicle> getAvailableVehicles(String category, int locationId, ChronoLocalDate pickupDate,
                                              ChronoLocalDate dropoffDate){

        List<Vehicle> vehicles=vehicleDao.findAll();

        Set<Vehicle> availableVehicles=new HashSet<>();
        List<Vehicle> av=new ArrayList<>();

        for(Vehicle v: vehicles){
            if(v.getVehicleSubcategory().getVehicleCategory().getVehicleCategoryName().equals(category)){
                if(v.getLocation().getLocationId()==locationId){
                    av.add(v);
                }
                }
            }
        }

        for(Vehicle v1:av) {
        List<Booking> bookings = bookingDao.findByVehicle(v1);
        for(Booking b: bookings){
            if(b.getPickupDate().compareTo(pickupDate)<0 && b.getDropoffDate().compareTo(pickupDate)<0){
                availableVehicles.add(v1);


            }
            else if(b.getPickupDate().compareTo(pickupDate)>0 && b.getPickupDate().compareTo(dropoffDate)>0){
                availableVehicles.add(v1);
            }
        }

        return availableVehicles;


    }

}
