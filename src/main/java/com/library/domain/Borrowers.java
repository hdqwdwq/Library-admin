package com.library.domain;

import lombok.Data;

@Data
public class Borrowers {
    private Long id;
    private String name;
    private Integer sex;
    private String age;
    private String phone;
    private Integer salt;
    private String password;
}
