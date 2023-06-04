package com.library.mapper.domain;

import lombok.Data;

/**图书分类*/
    @Data
    public class Category {
        /**编号*/
        private Long id;
        /**书名*/
        private String name;
        /**状态*/
        private int state;
    }

