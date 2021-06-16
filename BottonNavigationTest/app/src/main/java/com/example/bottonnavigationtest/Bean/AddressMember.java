package com.example.bottonnavigationtest.Bean;

public class AddressMember {

    private String name;
    private String number;
    private String number2;
    private String workPlace;
    private String email;
    private String address;
    private int sNum;

    public AddressMember(int sNum, String name, String number, String number2, String workPlace, String email, String address) {
        this.name = name;
        this.number = number;
        this.number2 = number2;
        this.workPlace = workPlace;
        this.email = email;
        this.address = address;
        this.sNum = sNum;
    }

    public AddressMember(String name, int sNum) {
        this.name = name;
        this.sNum = sNum;
    }

    public AddressMember(String name, String number, String number2, String workPlace, String email, String address) {
        this.name = name;
        this.number = number;
        this.number2 = number2;
        this.workPlace = workPlace;
        this.email = email;
        this.address = address;
//        this.sNum = sNum;
    }


//G/S

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }
}
