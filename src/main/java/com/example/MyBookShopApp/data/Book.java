package com.example.MyBookShopApp.data;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private Author author;
    private String title;
    private String priceOld;
    private String price;
}
