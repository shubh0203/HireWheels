package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingDao extends JpaRepository<booking,Integer>{
}
