package com.library.model;

import java.time.LocalDateTime;

public class Lend {
    private int id;
    private static int idCounter = 1;
    private final Book book;
    private final LocalDateTime lendDate;
    private LocalDateTime returnDate;
    private boolean active;

    public Lend(Book book) {
        this.id = idCounter++;
        this.book = book;
        this.lendDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getLendDate() {
        return lendDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return active;
    }

    public void returnBook() {
        this.returnDate = LocalDateTime.now();
        this.active = false;
        this.book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Lend{" +
                "id=" + id +
                ", book=" + book +
                ", lendDate=" + lendDate +
                ", returnDate=" + returnDate +
                ", active=" + active +
                '}';
    }
}
