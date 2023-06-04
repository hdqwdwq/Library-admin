package com.library.mapper;

import com.library.mapper.domain.Borrowers;
import com.library.service.query.BorrowersQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BorrowersMapper {
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
    //分页+条件查询
    List<Borrowers> selectByPage(BorrowersQuery query);
    //总条数
    Long count(BorrowersQuery query);
    void batchDelete(List<Long> ids);
}
