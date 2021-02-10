package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cityDao extends JpaRepository<City,Integer> {
}
