package com.hotelmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelmanagement.entities.Booking;

public interface BookingService {
	public void createBooking(Booking booking);
	public List<Booking> getAllBookings();
	public Booking getBookingById(int id);
	public ResponseEntity<String> updateBooking(int id, Booking booking);
	public ResponseEntity<String> cancelBooking(int id);
}
