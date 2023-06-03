package com.library.service.impl;

import com.library.domain.Book;
import com.library.mapper.IBookMapper;
import com.library.service.query.BookQuery;
import com.library.service.IBookService;
import com.library.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IBookServiceImpl implements IBookService {

    @Autowired
    private IBookMapper bookMapper;
    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public Book selectById(long id) {

        return bookMapper.selectById(id);
    }

    @Override
    public void add(Book book) {
        bookMapper.add(book);
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void deleteById(long id) {
        bookMapper.deleteById(id);
    }

    @Override
    public PageList<Book> queryByPage(BookQuery query) {
        //new一个pagelist来接收参数
        PageList<Book> pageList =new PageList<>();
        //查询当前页的数据
        List<Book> rows = bookMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total=bookMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }
    @Override
    public void batchDelete(List<Long> ids){
        bookMapper.batchDelete(ids);
    }
}