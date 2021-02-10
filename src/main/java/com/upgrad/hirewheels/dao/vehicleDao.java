package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vehicleDao extends JpaRepository<Vehicle, Integer> {
}
