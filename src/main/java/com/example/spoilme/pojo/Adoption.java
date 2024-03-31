package com.example.spoilme.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("t_adoption")
public class Adoption {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String cover;
    @TableField(value = "pet_name")
    private String petName;
    private String sex;
    private String age;
    private String sterilization;
    private String phone;
    private String email;
    private String variety;
    private String area;
    private String vaccination;
    private String wx;
    private String comment;
    private String status;
    private Date time;
    private String cause;
}
