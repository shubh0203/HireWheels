package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.entities.Vehicle_subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findAll();
    List<Vehicle> findByVehicleSubcategory(Vehicle_subcategory vehicleSubcategory);
}
