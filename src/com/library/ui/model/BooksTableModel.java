package com.library.ui.model;

import com.library.model.Author;
import com.library.model.Book;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BooksTableModel extends AbstractTableModel {
    private final String[] columns = {"ID", "Title", "Available", "Date Created", "Date Updated", "Author"};
    private List<Book> books;

    public BooksTableModel(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch(columnIndex) {
            case 0 -> books.get(rowIndex).getId();
            case 1 -> books.get(rowIndex).getTitle();
            case 2 -> (books.get(rowIndex).isAvailable()) ? "Yes" : "No";
            case 3 -> books.get(rowIndex).getDateCreated();
            case 4 -> books.get(rowIndex).getDateUpdated();
            case 5 -> books.get(rowIndex).getAuthor().getName();
            default -> "-";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Integer.class;
            default -> String.class;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
