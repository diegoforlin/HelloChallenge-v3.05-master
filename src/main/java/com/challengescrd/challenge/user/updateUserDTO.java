package com.challengescrd.challenge.user;

import com.challengescrd.challenge.address.Address;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record updateUserDTO(@NotNull Long id, String cellphone, String name, Address address) {


    public Date birthdate() {
        return null;
    }

    public String cpf() {
        return null;
    }
}
