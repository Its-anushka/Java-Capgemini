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

import com.hotelmanagement.entities.Room;
import com.hotelmanagement.service.RoomService;

@RestController
@RequestMapping(value = "hotel")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping(value = "/rooms")
	public List<Room> displayAllRooms(){
		return roomService.getAllRooms();
	}
	
	@GetMapping(value = "/rooms/{id}")
	public Room getRoomById(@PathVariable String id) {
		return roomService.getRoomById(id);
	}
	
	@PostMapping(value = "/rooms")
	public ResponseEntity<String> addRoom(@RequestBody Room room){
		roomService.createRoom(room);
		return new ResponseEntity("Room successfully added!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/rooms/{id}")
	public ResponseEntity<String> updateRoom(@PathVariable String id, @RequestBody Room room){
		return roomService.updateRoom(id, room);
	}
	
	@DeleteMapping(value = "/rooms/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable String id){
		return roomService.deleteRoom(id);
	}
	
}
