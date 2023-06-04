package com.library.controller;

import com.library.config.MD5Utils;
import com.library.mapper.domain.Borrowers;
import com.library.service.query.BorrowersQuery;
import com.library.service.BorrowersService;
import com.library.until.JsonResult;
import com.library.until.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController//controller+responBody
@RequestMapping("/Borrower")
@Api(tags = "借阅者管理 易杨")
public class BorrowersController {
    @Autowired
    private BorrowersService borrowersService;
    //查询所有
    @GetMapping
    @ApiOperation(value = "查询所有借阅者 易杨")
    public List<Borrowers> queryALL(){
        return borrowersService.selectAll();
    }
    //根据id查询
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询借阅者 易杨 ")
    public Borrowers queryById(@PathVariable("id")Long id){
        return borrowersService.selectByid(id);
    }
    //分页查询+条件查询+统计条数
    @ApiOperation(value = "分页查询+条件查询+统计条数 易杨")
    @PostMapping
    public PageList<Borrowers> queryByPage(@RequestBody BorrowersQuery query){
        return borrowersService.queryByPage(query);
    }
    //新增+修改
    @PutMapping
    @ApiOperation(value = "新增+修改借阅者信息 易杨")
    public JsonResult addOrupdata(@RequestBody Borrowers borrowers){
        try{

            borrowers.setPassword(MD5Utils.string2MD5(borrowers.getPassword()));
            if(borrowers.getId()==null){
                borrowersService.add(borrowers);
            }else{
                borrowersService.update(borrowers);
            }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    //根据id删除
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除借阅者信息 易杨")
    public JsonResult deleteById(@PathVariable("id")Long id){
        try{
            borrowersService.deleteByid(id);
            return new JsonResult();
        }catch(Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    //批量删除
    @PatchMapping
    @ApiOperation(value = "批量删除借阅者信息 易杨")
    public JsonResult batchDelete(@RequestBody List<Long>ids){
        try{
            borrowersService.batchDelete(ids);
            return new JsonResult();
        }catch(Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
}
