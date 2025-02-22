package com.library;

import com.library.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class LibraryProject {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        Author author1 = new Author(1, "Rhonda Byrne", LocalDate.of(1951, Month.MARCH, 12));
        Author author2 = new Author(2, "Arthur Conan Doyle", LocalDate.of(1859, Month.MAY, 22));

        library.addAuthor(author1);
        library.addAuthor(author2);

        List<Author> authorList = library.getAuthors();

        authorList.forEach(author -> System.out.println(author.getName()));

        Book book1 = new Book(1, "The Secret", author1);
        Book book2 = new Book(2, "The Magic", author1);
        Book book3 = new Book(3, "The Greatest Secret", author1);
        Book book4 = new Book(4, "Sherlock Holmes", author2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        while (true) {
            System.out.println("Do you want to check the available books? (yes/no)");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                List<Book> availableBooks = library.getAvailableBooks();

                if (availableBooks.isEmpty()) {
                    System.out.println("There are no available books at this moment.");
                } else {
                    System.out.println("Available books:");

                    for (Book book : availableBooks) {
                        System.out.println(book.getId() + ": " + book.getTitle());
                    }

                    System.out.println("Choose the book ID that you wish to lend:");

                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    Book selectedBook = library.findBookById(bookId);

                    if (selectedBook != null && selectedBook.isAvailable()) {
                        library.lendBook(selectedBook);
                        System.out.println("The book " + selectedBook.getTitle() + " was lent.");
                    } else {
                        System.out.println("Book not found or not available for lend.");
                    }
                }
            } else if (answer.equals("no")) {
                System.out.println("Thanks for using the library system.");
                break;
            } else {
                System.out.println("Invalid answer.");
            }
        }

        scanner.close();
    }
}
