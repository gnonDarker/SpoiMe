package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Integer petId;//ID
    private String petName;//用户名
    private Integer petOwnerId;//主人id
    private Integer petSex;//宠物性别
    private Integer petAge;//年龄
    private String petAddress;//地址
    private String petBreed;//品种
    private Integer petVaccine;//疫苗接种针数
    private String petParasite;//驱虫状态
    private Boolean petAdopt;//领养状态
    private Boolean petIsNeuter;//是否绝育
}
