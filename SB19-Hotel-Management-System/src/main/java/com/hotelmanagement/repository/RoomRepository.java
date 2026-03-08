package com.hotelmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotelmanagement.entities.Room;

public interface RoomRepository extends CrudRepository<Room, String>{
	
}
