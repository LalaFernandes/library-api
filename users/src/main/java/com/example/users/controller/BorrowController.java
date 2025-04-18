package com.example.users.controller;

import com.example.users.model.Book;
import com.example.users.model.Borrow;
import com.example.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    private List<Borrow> borrows = new ArrayList<>();
    List<User> users = UserController.getUsers();

    List<Book> books = BookController.getBooks();

    @PostMapping
    public ResponseEntity<String> borrowBook(@RequestParam int userId, int bookId) {

        Optional<User> maybeUser = users.stream()
                .filter(userStream-> userStream.getId() == userId)
                .findFirst();

        if (maybeUser.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }

        Optional<Book> maybeBook = books.stream()
                .filter(bookStream -> bookStream.getId() == bookId)
                .findFirst();

        if (maybeBook.isEmpty()) {
            return ResponseEntity.badRequest().body("Livro não encontrado.");
        }

        if (maybeBook.get().isBorrowed()) {
            return ResponseEntity.badRequest().body("Livro já está emprestado.");
        }

        maybeBook.get().setBorrowed(true);

        Borrow borrowed = new Borrow(maybeUser.get(), maybeBook.get());
        borrows.add(borrowed);
        return ResponseEntity.ok("Empréstimo registrado com sucesso.");
    }

    @GetMapping
    public List<Borrow> getBorrows() {
        return borrows;
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBorrow(@RequestParam int borrowId) {
        Optional<Borrow> maybeBorrow = borrows.stream()
                .filter(borrow -> borrow.getId() == borrowId)
                .findFirst();

        if (maybeBorrow.isEmpty()) {
            return ResponseEntity.badRequest().body("Empréstimo não encontrado.");
        }

        Borrow borrow = maybeBorrow.get();

        borrow.getBook().setBorrowed(false);

        borrows.remove(borrow);

        return ResponseEntity.ok("Deletado com sucesso.");
    }
}
