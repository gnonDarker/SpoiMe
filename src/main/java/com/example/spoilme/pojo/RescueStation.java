package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RescueStation {
    private Integer id;
    private Integer ownerId;
    private String address;
    private String phone;
    private String qrcode;
}
