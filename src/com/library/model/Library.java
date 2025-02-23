package com.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Lend> lends = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> filteredList;

        filteredList = books.stream()
                .filter((book -> book.isAvailable()))
                .collect(Collectors.toList());

        return filteredList;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(int id, String newTitle) {
        Book bookToUpdate = findBookById(id);

        if(bookToUpdate != null)
            bookToUpdate.setTitle(newTitle);
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Author findAuthorById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public void updateAuthor(int id, String newName, LocalDate newBirthDate) {
        Author authorToUpdate = findAuthorById(id);

        if(authorToUpdate != null) {
            authorToUpdate.setName(newName);
            authorToUpdate.setBirthDate(newBirthDate);
        }
    }

    public void removeAuthor(int id) {
        authors.removeIf(author -> author.getId() == id);
    }

    public List<Lend> getLends() {
        return lends;
    }

    public void lendBook(Book book) {
        if(book.isAvailable()) {
            Lend lend = new Lend(book);
            lends.add(lend);
            book.setAvailable(false);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public Lend findLendById(int id) {
        for (Lend lend : lends) {
            if (lend.getId() == id) {
                return lend;
            }
        }
        return null;
    }

    public void returnBook(int lendId) {
        Lend lendToFinish = findLendById(lendId);

        if(lendToFinish != null && lendToFinish.isActive()) {
            lendToFinish.returnBook();
        }
    }
}
