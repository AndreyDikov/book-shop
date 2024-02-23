package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.SqlQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Author getAuthorById(Integer id) {
        return jdbcTemplate.query(SqlQueries.getAuthorById(id),
                (ResultSet rs, int rowNum) -> new Author(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"))
        ).get(0);
    }

    public Map<Character, List<String>> getAuthorsData() {
        Map<Character, List<String>> authorsByFirstLettersName = new HashMap<>();
        for (char firstLetter = 'A'; firstLetter <= 'Z'; firstLetter++) {
            List<String> authors = jdbcTemplate.query(
                    SqlQueries.getAllAuthorsByFirstLetter(firstLetter),
                    (ResultSet rs, int rowNum) ->
                            rs.getString("first_name") + " " + rs.getString("last_name"));
            authorsByFirstLettersName.put(firstLetter, authors);
        }
        return authorsByFirstLettersName;
    }
}
