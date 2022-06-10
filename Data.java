package com.example.model;

public class Data implements Comparable<Data>{
    public int city;
    public String streetAddr;
    public int phone;

    public Data(int city, String streetAddr, int phone) {
        this.city = city;
        this.streetAddr = streetAddr;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "com.example.model.Data{" +
                "city=" + city +
                ", streetAddr='" + streetAddr + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Data data = (Data) obj;
        return data.phone == phone && data.streetAddr.equals(streetAddr) && data.city == city;
    }

    @Override
    public int compareTo(Data data) {
        return phone - data.phone;
    }
}
