package com.library.controller;

import com.library.domain.Book;
import com.library.service.query.BookQuery;
import com.library.service.IBookService;
import com.library.until.JsonResult;
import com.library.until.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Book")
@Api(tags = "书籍管理 尤坤")
public class BookController {
    @Autowired
    private IBookService bookService;
    //查询所有
    @GetMapping
    @ApiOperation(value = "查询所有书籍 尤坤")
    public List<Book>queryAll(){
        return bookService.selectAll();
    }
    //根据id查询
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询 尤坤")
    public Book queryById(@PathVariable("id")Long id){
        return bookService.selectById(id);
    }
    //分页查询
    @PostMapping
    @ApiOperation(value = "分页查询 尤坤")
    public PageList<Book> queryByPage(@RequestBody BookQuery query){
        return bookService.queryByPage(query);
    }

    //新增+修改
    @PutMapping
    @ApiOperation(value = "新增+修改 尤坤")
    public JsonResult addOrupdata(@RequestBody Book book){
        try{
          if (book.getId()==null){
              bookService.add(book);
          }else {
              bookService.update(book);
          }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 尤坤")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            bookService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
    //批量删除
    @PatchMapping
    @ApiOperation(value = "批量删除 尤坤")
    public JsonResult bathDelete(@RequestBody List<Long>ids){
        try {
            bookService.batchDelete(ids);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
}