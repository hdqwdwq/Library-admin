package com.library.service;

import com.library.mapper.domain.Seat;

import java.util.List;

public interface SeatService {

    List<Seat> selectAll();

    //编辑
    void update(Seat seat);

    //新增座位
    void add(Seat seat);

    //删除
    void deleteById(long id);

    Seat selectByPositionid(String position_id);
}