package io.drivesaf.springboot.quickstart.controller;

import io.drivesaf.springboot.quickstart.dto.BookDTO;
import io.drivesaf.springboot.quickstart.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 18:50
 * @description:
 **/
@RestController
@RequestMapping
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }
}
