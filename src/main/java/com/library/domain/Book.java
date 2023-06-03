package com.library.domain;
import lombok.Data;

/**图书*/
@Data
public class Book {
    /**编号*/
    private Long id;
    /**书名*/
    private String title;
    /**作者*/
    private String author;
    /**分类编号*/
    private Long categoryId;
    /**出版日期*/
    private Long publishDate;
    /**书号*/
    private int state;
    /**分类*/
    private Category category;
}

