package com.hotelmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.entities.Booking;
import com.hotelmanagement.repository.BookingRepository;
import com.hotelmanagement.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository BookingRepos;
	
	@Override
	public void createBooking(Booking Booking) {
		BookingRepos.save(Booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> Bookings = new ArrayList<>();
	    BookingRepos.findAll().forEach(Bookings::add);
	    return Bookings;
	}

	@Override
	public Booking getBookingById(int id) {
		return BookingRepos.findById(id).get();
	}

	@Override
	public ResponseEntity<String> updateBooking(int id, Booking booking) {
		Booking r = BookingRepos.findById(id).get();
		if (r == null) {
			return new ResponseEntity<>("Booking not found!", HttpStatus.BAD_REQUEST);
		}
		BookingRepos.save(booking);
		return new ResponseEntity<>("Booking updated!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> cancelBooking(int id) {
		Booking r = BookingRepos.findById(id).get();
		if (r == null) {
			return new ResponseEntity<>("Booking not found!", HttpStatus.BAD_REQUEST);
		}
		BookingRepos.delete(r);
		return new ResponseEntity<>("Booking cancelled!", HttpStatus.OK);
	}
}
