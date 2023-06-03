package com.library.until;

import com.library.config.MD5Utils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageList<T> {
    //接收当前查询到的数据
    List<T>rows=new ArrayList<>();
    //介绍条数
    Long total;
}
