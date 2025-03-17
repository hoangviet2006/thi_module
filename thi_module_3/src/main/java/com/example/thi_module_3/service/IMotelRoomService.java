package com.example.thi_module_3.service;

import com.example.thi_module_3.dto.MotelRoomDto;
import com.example.thi_module_3.model.MotelRoom;

import java.util.List;

public interface IMotelRoomService {
    List<MotelRoomDto> getMotelRooms();
    boolean addMotelRoom(MotelRoom motelRoom);
    boolean deleteMotelRoom(int id);
    List<MotelRoomDto> searchMotelRoom(String keyword);
}
