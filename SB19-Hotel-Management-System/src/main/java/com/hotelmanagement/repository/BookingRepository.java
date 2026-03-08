package com.hotelmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotelmanagement.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{

}
