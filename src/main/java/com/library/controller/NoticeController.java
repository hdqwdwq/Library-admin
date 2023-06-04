package com.library.controller;


import com.library.mapper.domain.Notice;
import com.library.service.query.NoticeQuery;
import com.library.service.NoticeService;
import com.library.until.JsonResult;
import com.library.until.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;


@ApplicationScope
@RestController
@RequestMapping("/Affiche")
@Api(tags = "公告管理 颜佳源")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    //查询所有
    @GetMapping
    @ApiOperation(value = "查询所有公告 颜佳源")
    public List<Notice>queryAll(){
        return noticeService.selectAll();
    }
    //根据id查询
    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询公告 颜佳源")
    public Notice queryById(@PathVariable("id")Long id){
        return noticeService.selectById(id);
    }
    //分页查询
    @PostMapping
    @ApiOperation(value = "分页查询公告 颜佳源")
    public PageList<Notice> queryByPage(@RequestBody NoticeQuery query){
        return noticeService.queryByPage(query);
    }

    @PutMapping
    @ApiOperation(value = "新增+修改公告 颜佳源")
    public JsonResult addOrupdata(@RequestBody Notice notice){
        try{
           if (notice.getId()==null){
               noticeService.add(notice);
            }else {
                noticeService.update(notice);
            }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除公告 颜佳源")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            noticeService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }

    //批量删除
    @PatchMapping
    @ApiOperation(value = "批量删除公告 颜佳源")
    public JsonResult bathDelete(@RequestBody List<Long>ids){
        try {
            noticeService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
}