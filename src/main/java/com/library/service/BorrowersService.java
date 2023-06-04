package com.library.service;

import com.library.mapper.domain.Borrowers;
import com.library.service.query.BorrowersQuery;
import com.library.until.PageList;

import java.util.List;

public interface BorrowersService {
    //查询全部
    List<Borrowers> selectAll();
    //根据id查询单条数据
    Borrowers selectByid(Long id);
    //新增
    void add(Borrowers borrowers);
    //编辑
    void update(Borrowers borrowers);
    //删除
    void deleteByid(Long id);
    //分页查询+查询总条数
    PageList<Borrowers> queryByPage(BorrowersQuery borrowersQuery);

    void batchDelete(List<Long> ids);
}
