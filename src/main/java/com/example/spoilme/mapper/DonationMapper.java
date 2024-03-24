package com.example.spoilme.mapper;

import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {
    @Insert("insert into t_donation_material(material_id, material_user_id, material_name, material_time) VALUE (#{materialId}, #{materialUserId}, #{materialName}, #{materialTime})")
    void addDonationMaterial(DonationMaterial donationMaterial);

    @Insert("insert into t_donation_money(money_id, money_user_id, money_price, money_time) VALUE (#{moneyId}, #{moneyUserId}, #{moneyPrice}, #{moneyTime})")
    void addDonationMoney(DonationMoney donationMoney);
}
