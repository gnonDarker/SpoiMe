package com.example.spoilme.mapper;

import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationMapper {
    @Insert("insert into t_donation_material(d_material_id, d_material_user_id, d_material_name, d_material_time) VALUE (#{dMaterialId}, #{dMaterialUserId}, #{dMaterialName}, #{dMaterialTime})")
    void addDonationMaterial(DonationMaterial donationMaterial);

    @Insert("insert into t_donation_money(d_money_id, d_money_user_id, d_money_price, d_money_time) VALUE (#{dMoneyId}, #{dMoneyUserId}, #{dMoneyPrice}, #{dMoneyTime})")
    void addDonationMoney(DonationMoney donationMoney);
}
