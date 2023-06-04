package com.library.service.impl;

import com.library.domain.Name;
import com.library.mapper.NameMapper;
import com.library.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NameServiceImpl implements NameService {
    @Autowired
    private NameMapper nameMapper;
    @Override
    public List<Name> selectAll() {
        return nameMapper.selectAll();
    }

    @Override
    public Name selectById(long id) {

        return nameMapper.selectById(id);
    }

    @Override
    public void add(Name name) {
        nameMapper.add(name);
    }

    @Override
    public void update(Name name) {
        nameMapper.update( name);
    }

    @Override
    public void deleteById(long id) {
        nameMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Long> ids){
        nameMapper.batchDelete(ids);
    }
}