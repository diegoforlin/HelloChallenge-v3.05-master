package com.challengescrd.challenge.address;

import jakarta.persistence.Embeddable;

import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Address {

    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void updateAddress(Address newAddress) {
        if (newAddress.getStreet() != null) {
            this.street = newAddress.getStreet();
        }
        if (newAddress.getNumber() != null) {
            this.number = newAddress.getNumber();
        }
        if (newAddress.getNeighborhood() != null) {
            this.neighborhood = newAddress.getNeighborhood();
        }
        if (newAddress.getCity() != null) {
            this.city = newAddress.getCity();
        }
        if (newAddress.getState() != null) {
            this.state = newAddress.getState();
        }
    }
}