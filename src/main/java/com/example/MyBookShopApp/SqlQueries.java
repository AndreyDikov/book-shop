package com.example.MyBookShopApp;

public class SqlQueries {
    public static String getAllAuthorsByFirstLetter(char firstLetter) {
        return "SELECT * FROM authors WHERE first_name LIKE '" + firstLetter + "%'";
    }

    public static String getAuthorById(int id) {
        return String.format("SELECT * FROM authors WHERE id = '%d'", id);
    }

    public static String getAllBooks() {
        return "SELECT * FROM books";
    }
}
