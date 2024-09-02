package io.drivasaf.springboot.quickstart.dto;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/02 18:42
 * @description:
 **/
public record BookDTO(Long id, String title, String author, double price) {
    public BookDTO {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}
