package com.library.ui.model;

import com.library.model.Author;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AuthorsTableModel extends AbstractTableModel {
    private final String[] columns = {"ID", "Name", "Birth Date"};
    private List<Author> authors;

    public AuthorsTableModel(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public int getRowCount() {
        return authors.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch(columnIndex) {
            case 0 -> authors.get(rowIndex).getId();
            case 1 -> authors.get(rowIndex).getName();
            case 2 -> authors.get(rowIndex).getBirthDate();
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
