package com.example.shopway.model;

public class UserSettings {
    private String name;
    private String age;
    private String address;
    private String city;
    private String postCode;

    public UserSettings(String name, String age, String address, String city, String postCode) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
    }

    public UserSettings() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
