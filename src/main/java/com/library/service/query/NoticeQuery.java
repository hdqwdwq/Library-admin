package com.library.service.query;

import lombok.Data;

@Data
public class NoticeQuery {
    private  Integer currentPage=1;
    //每页显示的条数
    private Integer pageSize=5;
    //计算起始行
    public  Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    //条件查询
    private String keyword;
}
