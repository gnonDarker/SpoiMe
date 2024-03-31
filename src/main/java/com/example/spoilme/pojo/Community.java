package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    private Integer id;
    private Integer userId;
    private String tittle;
    private String content;
    private Integer like;
    private String tag;
    private Time createTime;
}
