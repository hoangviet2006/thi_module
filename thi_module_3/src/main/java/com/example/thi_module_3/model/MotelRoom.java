package com.example.thi_module_3.model;

public class MotelRoom {
    private  int stt;
    private String tenantName;
    private String code;
    private String phoneNumber;
    private String rentalDate;
    private String formOfPayment;
    private String note;
    private int id_pay;

    public MotelRoom() {
    }

    public MotelRoom( String code,String tenantName,  String phoneNumber, String rentalDate, String note, int id_pay) {
        this.code = code;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.note = note;
        this.id_pay = id_pay;
    }

    public MotelRoom(int stt, String code, String tenantName, String phoneNumber, String rentalDate, String note, int id_pay) {
        this.stt = stt;
        this.code = code;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.note = note;
        this.id_pay = id_pay;
    }

    public MotelRoom(int stt, String name, String code, String phoneNumber, String rentalDate, String formOfPayment, String note, int id_pay) {
        this.stt = stt;
        this.tenantName = name;
        this.code = code;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.formOfPayment = formOfPayment;
        this.note = note;
        this.id_pay = id_pay;
    }

    public MotelRoom(String code, String tenantName, String phoneNumber, String rentalDate, String formOfPayment, String note, int id_pay) {
        this.code = code;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.formOfPayment = formOfPayment;
        this.note = note;
        this.id_pay = id_pay;
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
}
