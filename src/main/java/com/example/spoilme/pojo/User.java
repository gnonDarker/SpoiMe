package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uId;//ID
    private String uName;//用户名
    private String UPassword;//密码
    private Integer uSex;//用户性别
    private Time uDate;//生日
    private String uMail;//邮箱
    private String uPhone;//手机
}
