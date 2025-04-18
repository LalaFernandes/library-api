package com.example.users.controller;

import com.example.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static List<User> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    @GetMapping
    public static List<User> getUsers() {
        return users;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam int userId) {
        users.removeIf(user -> user.getId() == userId);
        return ResponseEntity.ok("Usuário removido com sucesso.");
    }

}
