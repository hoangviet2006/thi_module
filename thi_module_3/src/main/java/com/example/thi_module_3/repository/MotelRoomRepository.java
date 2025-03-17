package com.example.thi_module_3.repository;

import com.example.thi_module_3.dto.MotelRoomDto;
import com.example.thi_module_3.model.MotelRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotelRoomRepository implements IMotelRoomRepository {
        private final static String SELECT_ALL = "select m.*,p.id,p.`name` from motel_room m left join pay p on m.id_pay=p.id";
    private final static String ADD = "insert into motel_room (`code`,tenant_name, phone_number, rental_date, form_of_payment, note, id_pay) value(?,?,?,?,?,?,?)";
    private final static String DELETE = "delete from motel_room where stt=?";
    private final static String SEARCH_CODE = "select m.*,p.id,p.`name` from motel_room m left join pay p on m.id_pay=p.id where code like ?";

    @Override
    public List<MotelRoomDto> getMotelRooms() {
        Connection collection =  BaseRepository.getConnectDB();
        List<MotelRoomDto> motelRoomList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = collection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int stt=  resultSet.getInt("stt");
                String tenantName = resultSet.getString("tenant_name");
                String code =resultSet.getString("code");
                String phoneNumber = resultSet.getString("phone_number");
                String rentalDate=resultSet.getString("rental_date");
                String formOfPayment = resultSet.getString("form_of_payment");
                String note = resultSet.getString("note");
                int id_pay=resultSet.getInt("id_pay");
                String name = resultSet.getString("name");
                MotelRoomDto motelRoom= new MotelRoomDto(stt,code,tenantName,phoneNumber,rentalDate,formOfPayment,note,id_pay,name);
                motelRoomList.add(motelRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return motelRoomList;
    }

    @Override
    public boolean addMotelRoom(MotelRoom motelRoom) {
       Connection connection=BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            preparedStatement.setString(1,motelRoom.getCode());
            preparedStatement.setString(2,motelRoom.getTenantName());
            preparedStatement.setString(3,motelRoom.getPhoneNumber());
            preparedStatement.setString(4,motelRoom.getRentalDate());
            preparedStatement.setString(5,motelRoom.getFormOfPayment());
            preparedStatement.setString(6,motelRoom.getNote());
            preparedStatement.setInt(7,motelRoom.getId_pay());
            int row = preparedStatement.executeUpdate();
            return row==1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteMotelRoom(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            int row = preparedStatement.executeUpdate();
            return row==1;

        } catch (SQLException e) {
            System.out.println("Lỗi");
            return false;
        }
    }

    @Override
    public List<MotelRoomDto> searchMotelRoom(String keyword) {
        List<MotelRoomDto> motelRoomList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CODE);
            preparedStatement.setString(1,"%"+keyword+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int stt=  resultSet.getInt("stt");
                String tenantName = resultSet.getString("tenant_name");
                String code =resultSet.getString("code");
                String phoneNumber = resultSet.getString("phone_number");
                String rentalDate=resultSet.getString("rental_date");
                String formOfPayment = resultSet.getString("form_of_payment");
                String note = resultSet.getString("note");
                int id_pay=resultSet.getInt("id_pay");
                String name = resultSet.getString("name");
                MotelRoomDto motelRoomDto = new MotelRoomDto(stt,code,tenantName,phoneNumber,rentalDate,formOfPayment,note,id_pay,name);
                motelRoomList.add(motelRoomDto);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return motelRoomList;
    }
}
