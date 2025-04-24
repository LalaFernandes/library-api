package com.example.users.controller;

import com.example.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
        int idFound = IntStream.range(0, users.size())
                .filter(i -> users.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if (idFound == -1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        users.get(idFound).setName(user.getName());
        users.get(idFound).setAge(user.getAge());
        return ResponseEntity.ok("Usuário atualizado com sucesso.");
    }
}
