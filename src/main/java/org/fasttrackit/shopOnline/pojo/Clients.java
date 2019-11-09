package org.fasttrackit.shopOnline.pojo;

public class Clients {
    private int id;
    private String type;
    private String name;
    private String address;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Clients(int id, String type, String name, String address, String phone, String email) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Clients() {
    }
}
