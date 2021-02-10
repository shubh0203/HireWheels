package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle_category;
import com.upgrad.hirewheels.entities.Vehicle_subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Vehicle_subcategoryDao extends JpaRepository<Vehicle_subcategory, Integer> {
    List<Vehicle_subcategory> findByVehicleCategory(Vehicle_category vehicleCategory);
}
