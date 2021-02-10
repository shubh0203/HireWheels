package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle_category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vehicle_categoryDao extends JpaRepository<Vehicle_category, Integer> {
     Vehicle_category  findById(int id);
     Vehicle_category findByVehicleCategoryName(String vehicleCategoryName);

}
