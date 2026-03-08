package com.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.entities.Booking;
import com.hotelmanagement.service.BookingService;

@RestController
@RequestMapping(value = "hotel")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping(value = "/bookings")
	public List<Booking> displayAllBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping(value = "/bookings/{id}")
	public Booking getBookingById(@PathVariable int id) {
		return bookingService.getBookingById(id);
	}
	
	@PostMapping(value = "/bookings")
	public ResponseEntity<String> addBooking(@RequestBody Booking booking){
		bookingService.createBooking(booking);
		return new ResponseEntity<String>("Booking successfully added!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/bookings/{id}")
	public ResponseEntity<String> updateBooking(@PathVariable int id, @RequestBody Booking booking){
		return bookingService.updateBooking(id, booking);
	}
	
	@DeleteMapping(value = "/bookings/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable int id){
		return bookingService.cancelBooking(id);
	}
	
}
