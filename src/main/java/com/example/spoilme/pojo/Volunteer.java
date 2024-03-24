package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volunteer {
    private Integer vId;
    private Integer vUserId;
    private String vName;
    private Boolean vSex;
    private Integer vPhone;
    private String vSpareTime;
    private String vWechat;
    private Boolean vExperience;
}
