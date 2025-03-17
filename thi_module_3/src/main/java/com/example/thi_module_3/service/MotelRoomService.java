package com.example.thi_module_3.service;

import com.example.thi_module_3.dto.MotelRoomDto;
import com.example.thi_module_3.model.MotelRoom;
import com.example.thi_module_3.repository.IMotelRoomRepository;
import com.example.thi_module_3.repository.MotelRoomRepository;

import java.util.List;

public class MotelRoomService implements IMotelRoomService {
        IMotelRoomRepository motelRoomRepository=new MotelRoomRepository();
    @Override
    public List<MotelRoomDto> getMotelRooms() {
        return motelRoomRepository.getMotelRooms();
    }

    @Override
    public boolean addMotelRoom(MotelRoom motelRoom) {
        return motelRoomRepository.addMotelRoom(motelRoom);
    }

    @Override
    public boolean deleteMotelRoom(int id) {
        return motelRoomRepository.deleteMotelRoom(id);
    }

    @Override
    public List<MotelRoomDto> searchMotelRoom(String keyword) {
        return motelRoomRepository.searchMotelRoom(keyword);
    }
}
