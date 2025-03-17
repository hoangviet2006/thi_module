package com.example.thi_module_3.model;

public class Pay {
    private int id;
    private String name;

    public Pay() {
    }

    public Pay(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
