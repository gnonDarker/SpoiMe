package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;//ID
    private String name;//用户名
    private String password;//密码
    private Integer sex;//用户性别
    private Timestamp date;//生日
    private String mail;//邮箱
    private String phone;//手机
}
