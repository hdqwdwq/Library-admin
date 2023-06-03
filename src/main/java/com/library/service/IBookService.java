package com.library.service;

import com.library.domain.Book;
import com.library.service.query.BookQuery;
import com.library.until.PageList;

import java.util.List;

public interface IBookService {
    List<Book> selectAll();
    //根据id查询单条数据
    Book selectById(long id);
    //新增
    void add(Book book);
    void update(Book book);
    void deleteById(long id);
    //分页查询+查询总条数
    PageList<Book> queryByPage(BookQuery query);

    void batchDelete(List<Long> ids);
}