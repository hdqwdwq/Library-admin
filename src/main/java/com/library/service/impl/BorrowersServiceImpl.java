package com.library.service.impl;

import com.library.domain.Borrowers;
import com.library.mapper.BorrowersMapper;
import com.library.service.query.BorrowersQuery;
import com.library.service.BorrowersService;
import com.library.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BorrowersServiceImpl implements BorrowersService {
    @Autowired
    private BorrowersMapper borrowersMapper;

    @Override
    public List<Borrowers> selectAll() {
        return borrowersMapper.selectAll();
    }

    @Override
    public Borrowers selectByid(Long id) {
        return borrowersMapper.selectByid(id);
    }

    @Override
    public void add(Borrowers borrowers) {
        borrowersMapper.add(borrowers);
    }

    @Override
    public void update(Borrowers borrowers) {
        borrowersMapper.update(borrowers);
    }

    @Override
    public void deleteByid(Long id) {
        borrowersMapper.deleteByid(id);
    }

    @Override
    public PageList<Borrowers> queryByPage(BorrowersQuery query) {
        //newYg pageList对象来接收参数
        PageList<Borrowers> pageList = new PageList<>();
        //查询当前页面的数据
        List<Borrowers> rows = borrowersMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = borrowersMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        borrowersMapper.batchDelete(ids);
    }
}
