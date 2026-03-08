package com.hotelmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotelmanagement.entities.Room;

public interface RoomService {
	public void createRoom(Room room);
	public List<Room> getAllRooms();
	public Room getRoomById(String id);
	public ResponseEntity<String> updateRoom(String id, Room room);
	public ResponseEntity<String> deleteRoom(String id);
}
