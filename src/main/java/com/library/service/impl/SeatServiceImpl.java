package com.library.service.impl;

import com.library.domain.Seat;
import com.library.mapper.AdminMapper;
import com.library.mapper.SeatMapper;
import com.library.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Override
    public List<Seat> selectAll() {
        return seatMapper.selectAll();
    }

    @Override
    public void update(Seat seat) {
        seatMapper.update(seat);
    }

    @Override
    public void add(Seat seat) {
        seatMapper.add(seat);
    }

    @Override
    public void deleteById(long id) {
        seatMapper.deleteById(id);
    }

    @Override
    public Seat selectByPositionid(String position_id) {
        return seatMapper.selectByPositionid(position_id);
    }
}
