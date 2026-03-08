package com.hotelmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.entities.Room;
import com.hotelmanagement.repository.RoomRepository;
import com.hotelmanagement.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomRepository roomRepos;
	
	@Override
	public void createRoom(Room room) {
		roomRepos.save(room);
	}

	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
	    roomRepos.findAll().forEach(rooms::add);
	    return rooms;
	}

	@Override
	public Room getRoomById(String id) {
		return roomRepos.findById(id).get();
	}

	@Override
	public ResponseEntity<String> updateRoom(String id, Room room) {
		Room r = roomRepos.findById(id).get();
		if (r == null) {
			return new ResponseEntity<>("Room not found!", HttpStatus.BAD_REQUEST);
		}
		roomRepos.save(room);
		return new ResponseEntity<>("Room status updated!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteRoom(String id) {
		Room r = roomRepos.findById(id).get();
		if (r == null) {
			return new ResponseEntity<>("Room not found!", HttpStatus.BAD_REQUEST);
		}
		roomRepos.delete(r);
		return new ResponseEntity<>("Room deleted!", HttpStatus.OK);
	}
}
