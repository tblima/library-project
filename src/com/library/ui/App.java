package com.library.ui;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Library;
import com.library.ui.model.AuthorsTableModel;
import com.library.ui.model.BooksTableModel;

public class App {
    private JPanel panelApp;
    private JTabbedPane tabbedPaneLibrary;
    private JPanel panelAuthors;
    private JPanel panelBooks;
    private JScrollPane scrollPaneAuthors;
    private JTable tableAuthors;
    private JButton buttonAddAuthor;
    private JScrollPane scrollPaneBooks;
    private JTable tableBooks;
    private JButton buttonAddBook;
    private JButton buttonEditAuthor;
    private JButton buttonEditBook;
    private JButton buttonRemoveBook;
    private JPanel panelBooksButtons;
    private JPanel panelAuthorsButtons;
    private JPanel panelMain;
    private JButton buttonRemoveAuthor;

    public static Library library;

    public App(Library library) {
        TableModel tableModelAuthors = new AuthorsTableModel(library.getAuthors());
        tableAuthors.setModel(tableModelAuthors);

        TableModel tableModelBooks = new BooksTableModel(library.getBooks());
        tableBooks.setModel(tableModelBooks);
    }

    public static void main(String[] args) {
        //Initialize values
        library = new Library();

        Author author1 = new Author(1, "Rhonda Byrne", LocalDate.of(1951, Month.MARCH, 12));
        Author author2 = new Author(2, "Arthur Conan Doyle", LocalDate.of(1859, Month.MAY, 22));

        library.addAuthor(author1);
        library.addAuthor(author2);

        Book book1 = new Book(1, "The Secret", author1);
        Book book2 = new Book(2, "The Magic", author1);
        Book book3 = new Book(3, "The Greatest Secret", author1);
        Book book4 = new Book(4, "Sherlock Holmes", author2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            // handle exception
            JOptionPane.showMessageDialog(null, "Error when loading system native class.");
        }

        JFrame frame = new JFrame("App");
        frame.setContentPane(new App(library).panelApp);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
