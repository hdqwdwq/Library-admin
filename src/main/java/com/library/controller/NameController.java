package com.library.controller;

import com.library.domain.Name;
import com.library.until.JsonResult;
import com.library.service.NameService;
import com.library.until.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
@RestController
@RequestMapping("/Name")
@Api(tags = "借阅排行榜管理 龚义峰")
public class NameController {

    @Autowired
    private NameService nameService;
    //查询所有
    @ApiOperation("查询所有排行榜信息 龚义峰")
    @GetMapping
    public List<Name> queryAll(){
        return nameService.selectAll();
    }
    //根据id查询
    @ApiOperation("根据id查询排行榜 龚义峰")
    @GetMapping("{id}")
    public Name queryById(@PathVariable("id")Long id){
        return nameService.selectById(id);
    }

    @ApiOperation("添加信息 龚义峰")
    @PutMapping
    public JsonResult addOrupdata(@RequestBody Name name){
        try{
            if (name.getId()==null){
                nameService.add(name);
            }else {
                nameService.update(name);
            }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    @ApiOperation("删除排行榜信息 龚义峰")
    @DeleteMapping("/{id}")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            nameService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }

    //批量删除
    @ApiOperation("批量删除排行榜信息 龚义峰")
    @PatchMapping
    public JsonResult bathDelete(@RequestBody List<Long>ids){
        try {
            nameService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
}
