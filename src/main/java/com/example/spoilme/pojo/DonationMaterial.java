package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationMaterial {
    private Integer dMaterialId;
    private Integer dMaterialUserId;
    private String dMaterialName;
    private Time dMaterialTime;
}
