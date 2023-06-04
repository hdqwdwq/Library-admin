package com.library.mapper;

import com.library.mapper.domain.Name;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NameMapper {
    List<Name> selectAll();
    //根据id查询单条数据
     Name selectById(long id);
    //新增
    void add(Name name);
    void update(Name name);
    void deleteById(long id);

    void batchDelete(List<Long> ids);
}
