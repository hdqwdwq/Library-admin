package com.library.domain;

import lombok.Data;

@Data
public class Admin {
    public Long id;
    public String username;
    public String salt;
    public String password;
    public String phone;
    public Integer state;
}
