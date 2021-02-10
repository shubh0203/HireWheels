package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingServiceImpl {
    @Autowired
    BookingDao bookingDao;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserDao userDao;



    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return bookingDao.findById(id)
                .orElseThrow(
                        () -> new BookingDetailsNotFoundException("Booking not found for id: " + id)
                );
    }


    public Booking addBooking(Booking booking)throws Exception, BookingDetailsNotFoundException, UserDetailsNotFoundException {
        User user=userService.getUserDetails((booking.getUser().getUserid()));

        if(user.getWalletMoney()-booking.getAmount()>0){
            user.setWalletMoney(user.getWalletMoney()-booking.getAmount());
            userDao.save(user);
            return bookingDao.save(booking);
        }
        throw new Exception("Insufficient Balance. Please Check With Admin");
    }
}
