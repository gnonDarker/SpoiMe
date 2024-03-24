package com.example.spoilme.service;

import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;

public interface DonationService {
    void donateMaterial(DonationMaterial donationMaterial);

    void donateMoney(DonationMoney donationMoney);
}
