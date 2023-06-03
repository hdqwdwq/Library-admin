package com.library.mapper;


import com.library.domain.Notice;
import com.library.service.query.NoticeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoticeMapper {


    Notice selectById(long id);
    //新增
    void add(Notice notice);
    void update(Notice notice);
    void deleteById(long id);
    //分页+条件查询
    List<Notice>selectByPage(NoticeQuery query);
    //计算总条数
    Long count(NoticeQuery query);


    List<Notice> selectAll();
    void batchDelete(List<Long> ids);
}

