package com.challengescrd.challenge.entities;

import com.challengescrd.challenge.address.Address;
import com.challengescrd.challenge.user.UserDTO;
import com.challengescrd.challenge.user.updateUserDTO;
import io.swagger.annotations.Api;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@Api
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Date birthdate;
    private String cellphone;
    @Embedded
    private Address address;
    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(Long id, String name, String cpf, Date birthdate, String cellphone, Address address) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.cellphone = cellphone;
        this.address = address;
    }

    public User(UserDTO user) {
        this.name = user.name();
        this.cpf = user.cpf();
        this.cellphone = user.cellphone();
        this.birthdate = user.birthdate();
        this.address = user.address();


    }

    public Long getId() {
        return id;
    }

    public void updateIntel(updateUserDTO user) {
        if (user.name() != null) {
            this.name = user.name();
        } if(user.cellphone() != null) {
            this.cellphone = user.cellphone();
        } if (user.address() != null) {
            this.address.updateAddress(user.address());
        } if(user.birthdate() != null) {
            this.birthdate = user.birthdate();
        } if(user.cpf() != null) {
            this.cpf = user.cpf();
        }
    }

    public String getStreet() {
        return this.address.getStreet();

    }

    public String getNumber() {
        return this.address.getNumber();

    }

    public String getNeighborhood() {
        return this.address.getNeighborhood();

    }

    public String getCity() {
        return this.address.getCity();

    }

    public String getState() {
        return this.address.getState();

    }
}

