package io.drivasaf.springboot.quickstart.service;
import io.drivasaf.springboot.quickstart.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 18:44
 * @description:
 **/
@Service
public class BookService {
    public List<BookDTO> getAllBooks(){
        return List.of(
                new BookDTO(1L, "Java Programming", "Alice",29.99),
                new BookDTO(2L, "Spring Boot Action", "Bob",39.00)
        );
    }
}
