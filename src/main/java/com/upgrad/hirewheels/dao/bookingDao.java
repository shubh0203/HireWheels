package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingDao extends JpaRepository<Booking,Integer>{
}
