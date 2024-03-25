package com.example.spoilme.service.impl;

import com.example.spoilme.mapper.DonationMapper;
import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;
import com.example.spoilme.service.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DonationServiceImpl implements DonationService {
    @Autowired
    private DonationMapper donationMapper;
    @Override
    public void donateMaterial(DonationMaterial donationMaterial) {
        donationMapper.addDonationMaterial(donationMaterial);
    }

    @Override
    public void donateMoney(DonationMoney donationMoney) {
        donationMapper.addDonationMoney(donationMoney);
    }

    @Override
    public List<DonationMaterial> getMaterialList() {
        return donationMapper.getMaterialList();
    }

    @Override
    public List<DonationMoney> getMoneyList() {
        return donationMapper.getMoneyList();
    }
}
