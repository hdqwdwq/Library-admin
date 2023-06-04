package com.library.controller;

import com.library.domain.Category;
import com.library.service.CategoryService;
import com.library.until.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//controller+responBody
@RequestMapping("/Category")
@Api(tags = "书籍类型管理 熊虹灵")
public class CategoryController {
    @Autowired()
    private CategoryService categoryService;
    @GetMapping
    @ApiOperation(value = "查询所有书籍类型 熊虹灵")
    public List<Category> queryAll(){
        return categoryService.selectAll();
    }
    //根据id查询
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询 熊虹灵")
    public Category queryByPosition(@PathVariable("id")Long id){return categoryService.selectById(id);}
    //新增+修改
    @PutMapping
    @ApiOperation(value = "书籍类型新增+修改 熊虹灵")
    public JsonResult addOrupdata(@RequestBody Category category){
        try{
            if (category.getId()==null){
                categoryService.add(category);
            }else {
                categoryService.update(category);
            }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            categoryService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
}
