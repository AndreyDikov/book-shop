package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.SqlQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorService authorService;

    Logger logger = Logger.getLogger(AuthorService.class.getName());

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate, AuthorService authorService) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorService = authorService;
    }

    public List<Book> getBooksData() {
        return new ArrayList<>(jdbcTemplate.query(SqlQueries.getAllBooks(),
                (ResultSet rs, int rowNum) -> new Book(
                        rs.getInt("id"),
                        authorService.getAuthorById(rs.getInt("author_id")),
                        rs.getString("title"),
                        rs.getString("price_old"),
                        rs.getString("price")
                )
        ));
    }
}
