package com.example.spoilme.controller;

import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DonationController {
    @Autowired
    private DonationService donationService;

    //捐物资
    @PostMapping("/donate/material")
    public Result donateMaterial(@RequestBody DonationMaterial donationMaterial){
        log.info("物资:"+donationMaterial);
        donationService.donateMaterial(donationMaterial);
        return Result.success("捐物资成功");
    }
    //捐款
    @PostMapping("/donate/money")
    public Result donateMoney(@RequestBody DonationMoney donationMoney){
        log.info("捐钱:"+donationMoney);
        donationService.donateMoney(donationMoney);
        return Result.success("捐款成功");
    }
    @PostMapping("/material/list")
    public Result getDonateMaterialList(){
        List<DonationMaterial> list = donationService.getMaterialList();
        return Result.success(list);
    }
    @PostMapping("/money/list")
    public Result getDonateMoneyList(){
        List<DonationMoney> list = donationService.getMoneyList();
        return Result.success(list);
    }
}
