package com.example.spoilme.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RescueStation {
    private Integer rId;
    private Integer rOwnerId;
    private String rAddress;
    private Integer rPhone;
    private String rQrcode;
}
