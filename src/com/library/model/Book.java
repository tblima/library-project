package com.library.model;

import java.time.LocalDateTime;

public class Book {
    private final int id;
    private String title;
    private boolean available;
    private final LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private final Author author;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.available = true;
        this.author = author;
        this.dateCreated = LocalDateTime.now();
        this.dateUpdated = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
        this.dateUpdated = LocalDateTime.now();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", available=" + available +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
