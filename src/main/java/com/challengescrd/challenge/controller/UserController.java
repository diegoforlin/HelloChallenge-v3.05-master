package com.challengescrd.challenge.controller;

import com.challengescrd.challenge.entities.User;
import com.challengescrd.challenge.entities.UserRepository;
import com.challengescrd.challenge.user.UserDTO;
import com.challengescrd.challenge.user.UserDTOListing;
import com.challengescrd.challenge.user.updateUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private Date birthdate;
    private User user;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar novo usuário")
    public void register(@RequestBody @Valid UserDTO user) {
        userRepository.save(new User(user));
    }

    @GetMapping("/users")
    @Operation(summary ="Achar usuários")
    public List<UserDTOListing> listing() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTOListing(
                        user.getId(),
                        user.getName(),
                        user.getCellphone(),
                        user.getAddress(),
                        user.getCpf(),
                        user.getBirthdate()
                ))
                .collect(Collectors.toList());
    }

    @PutMapping
    @Transactional
    @Operation(summary ="Alterar usuários")
    public void update(@RequestBody @Valid updateUserDTO user) {
        User User = userRepository.getReferenceById(user.id());

        User.updateIntel(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary ="Deletar usuários")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}