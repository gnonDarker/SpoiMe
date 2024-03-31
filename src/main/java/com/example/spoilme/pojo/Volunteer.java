package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volunteer {
    private Integer id;
    private Integer userId;
    private String name;
    private Short sex;
    private String phone;
    private String wechat;
    private String spareTime;
    private Short experience;
    private String nickname;
    private Integer age;
    private String address;
    private String skill;
    private String state;
}
