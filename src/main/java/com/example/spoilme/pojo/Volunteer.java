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
    private Boolean sex;
    private Integer phone;
    private String spareTime;
    private String wechat;
    private Boolean experience;
}
