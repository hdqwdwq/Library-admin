package com.library.mapper;

import com.library.domain.Book;
import com.library.service.query.BookQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBookMapper {

    List<Book> selectAll();

        //根据id查询单条数据
    Book selectById(long id);
    //新增
    void add(Book book);
    void update(Book book);
    void deleteById(long id);
    //分页+条件查询
    List<Book>selectByPage(BookQuery query);
    //计算总条数
    Long count(BookQuery query);

    void batchDelete(List<Long> ids);
}
