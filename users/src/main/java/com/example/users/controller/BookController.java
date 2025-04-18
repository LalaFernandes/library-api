package com.example.users.controller;

import com.example.users.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private static List<Book> books = new ArrayList<>();

    @GetMapping
    public static List<Book> getBooks() {
        return books;
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }

    @GetMapping("/by-category")
    public List<Book> getBookByCategory(@RequestParam("category") String category) {
        if (category == null) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestParam int bookId) {
        books.removeIf(book -> book.getId() == bookId);
        return ResponseEntity.ok("Livro removido com sucesso.");
    }
}
