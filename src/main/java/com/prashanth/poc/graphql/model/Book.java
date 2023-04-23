package com.prashanth.poc.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorId;

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 635, "author-2"),
            new Book("book-3", "Interview with the vampire", 371, "author-3")
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public static Book getByName(String name) {
        return books.stream().filter(book -> book.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
