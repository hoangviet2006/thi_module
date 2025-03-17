package com.example.thi_module_3.dto;

public class MotelRoomDto {
    private  int stt;
    private String tenantName;
    private String code;
    private String phoneNumber;
    private String rentalDate;
    private String formOfPayment;
    private String note;
    private int id_pay;
    private String name;

    public MotelRoomDto() {
    }

    public MotelRoomDto(int stt, String code, String tenantName, String phoneNumber, String rentalDate, String formOfPayment, String note, int id_pay, String name) {
        this.stt = stt;
        this.code = code;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.formOfPayment = formOfPayment;
        this.note = note;
        this.id_pay = id_pay;
        this.name = name;
    }

    public MotelRoomDto(int stt, String code, String tenantName, String phoneNumber, String rentalDate, String note, int id_pay, String name) {
        this.stt = stt;
        this.code = code;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.note = note;
        this.id_pay = id_pay;
        this.name = name;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(String formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId_pay() {
        return id_pay;
    }

    public void setId_pay(int id_pay) {
        this.id_pay = id_pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
