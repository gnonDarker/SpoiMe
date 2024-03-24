package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationMaterial {
    private Integer dMaterialId;
    private Integer dMaterialUserId;
    private String dMaterialRescueName;
    private String dMaterialCourierNumber;
    private String dMaterialName;
    private Short dMaterialIsAnonym;
    private String dMaterialPhone;
    private String dMaterialMessage;
    private Time dMaterialTime;
}
