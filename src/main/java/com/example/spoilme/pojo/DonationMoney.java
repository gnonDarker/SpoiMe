package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationMoney {
    private Integer dMoneyId;
    private Integer dMoneyUserId;
    private Float dMoneyPrice;
    private Time dMoneyTime;
}
