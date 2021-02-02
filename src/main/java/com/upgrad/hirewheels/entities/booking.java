package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class booking {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="booking_Id",length = 10)
    private int bookingId;

    @Column(name="pickup_date",nullable = false)
    private LocalDate pickupDate;

    @Column(name="dropoff_date",nullable = false)
    private LocalDate dropoffDate;

    @Column(name="booking_date",nullable = false)
    private LocalDate bookingDate;

    @Column(length=10,nullable = false)
    private double amount;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "booking {"+
                "booking_id="+bookingId+'\''+
                "pickup_date="+pickupDate+'\''+
                "dropoff_date="+dropoffDate+'\''+
                "booking_date="+bookingDate+'\''+
                "amount="+amount+'\''+
                "}";
    }
}
