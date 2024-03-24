package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationMoney {
    private Integer moneyId;
    private Integer moneyUserId;
    private String moneyRescueName;
    private String moneyCourierNumber;
    private Float moneyPrice;
    private Short moneyIsAnonym;
    private String moneyPhone;
    private String moneyMessage;
    private Time moneyTime;
}
