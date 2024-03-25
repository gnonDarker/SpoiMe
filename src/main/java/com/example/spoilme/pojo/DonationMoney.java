package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationMoney {
    private Integer moneyId;
    private Integer moneyUserId;
    private String moneyRescueName;
    private String moneyUserName;
    private Short moneyIsAnonym;
    private Float moneyPrice;
    private String moneyPhone;
    private String moneyMessage;
    private Timestamp moneyTime;
}
