package com.library.mapper;

import com.library.mapper.domain.Seat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeatMapper {
    List<Seat> selectAll();
    //编辑
    void update(Seat Seat);
    //新增座位
    void add(Seat seat);
    //删除
    void deleteById(long id);
    Seat selectByPositionid(String position_id);
}
