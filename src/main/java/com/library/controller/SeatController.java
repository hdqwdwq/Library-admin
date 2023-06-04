package com.library.controller;

import com.library.domain.Seat;
import com.library.service.SeatService;
import com.library.until.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//controller+responBody
@RequestMapping("/Seat")
@Api(tags = "座位管理 周燕")
public class SeatController {
    @Autowired
    private SeatService seatService;
    //查询所有
    //根据position_id查询
    @GetMapping("/{position_id}")
    @ApiOperation(value = "根据position_id查询 周燕")
    public Seat queryByPosition(@PathVariable("position_id")String position_id){return seatService.selectByPositionid(position_id);}
    //新增+修改
    @PutMapping
    @ApiOperation(value = "用户新增+修改 周燕")
    public JsonResult addOrupdata(@RequestBody Seat seat){
        try{
            if (seat.getId()==null){
                seatService.add(seat);
            }else {
                seatService.update(seat);
            }
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"操作失败");
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除 周燕")
    public JsonResult deleteById(@PathVariable("id") Long id){
        try {
            seatService.deleteById(id);
            return new JsonResult();
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,"删除失败");
        }
    }
}