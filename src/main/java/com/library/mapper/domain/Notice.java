package com.library.mapper.domain;
import lombok.Data;


@Data
public class Notice {

    private Long id;


    private String notice_title;


    private int notice_type;


    private int notice_status;

    private String notice_content;


    private String create_by;



}

