package com.library.service.impl;


import com.library.domain.Notice;
import com.library.mapper.NoticeMapper;
import com.library.service.query.NoticeQuery;
import com.library.service.NoticeService;
import com.library.until.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> selectAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public Notice selectById(long id) {

        return noticeMapper.selectById(id);
    }

    @Override
    public void add(Notice notice) {
        noticeMapper.add(notice);
    }

    @Override
    public void update(Notice notice) {
        noticeMapper.update(notice);
    }

    @Override
    public void deleteById(long id) {
        noticeMapper.deleteById(id);
    }

    @Override
    public PageList<Notice> queryByPage(NoticeQuery query) {
        //new一个pagelist来接收参数
        PageList<Notice> pageList =new PageList<>();
        //查询当前页的数据
        List<Notice> rows = noticeMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total=noticeMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }
    @Override
    public void batchDelete(List<Long> ids){
        noticeMapper.batchDelete(ids);
    }

}
