package com.library.service;

import com.library.domain.Notice;
import com.library.service.query.NoticeQuery;
import com.library.until.PageList;

import java.util.List;


public interface NoticeService {

    List<Notice> selectAll();
    //根据id查询单条数据
    Notice selectById(long id);
    //新增
    void add(Notice notice);
    void update(Notice notice);
    void deleteById(long id);
    //分页查询+查询总条数
    PageList<Notice> queryByPage(NoticeQuery query);

    void batchDelete(List<Long> ids);
}
