package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RescueStation {
    private Integer id;
    private Integer ownerId;
    private String stationName;
    private Date foundTime;
    private Integer numberPeople;
    private String workCondition;
    private String address;
    private Integer numberPet;
    private Integer numberHelpPet;
    private Float amountLossPerMouth;
    private Boolean isNeedVolunteer;
    private String qrcode;
    private String shippingAddress;
    private String officialWebsite;
    private String administrator;
    private String wechat;
    private String mail;
    private String phone;
    private String rejectReason;
    private String state;
}
