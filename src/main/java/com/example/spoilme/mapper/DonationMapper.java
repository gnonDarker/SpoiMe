package com.example.spoilme.mapper;

import com.example.spoilme.pojo.DonationMaterial;
import com.example.spoilme.pojo.DonationMoney;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DonationMapper {
    @Insert("insert into t_donation_material(material_user_id, material_rescue_name, material_user_name, material_courier_number, material_name, material_is_anonym, material_phone, material_message, material_time) " +
            "VALUE (#{materialUserId}, #{materialRescueName}, #{materialUserName}, #{materialCourierNumber}, #{materialName}, #{materialIsAnonym}, #{materialPhone}, #{materialMessage}, #{materialTime})")
    void addDonationMaterial(DonationMaterial donationMaterial);

    @Insert("insert into t_donation_money(money_user_id, money_resucue_name, money_username, money_is_anonym, money_price, money_phone, money_message, money_time) " +
            "VALUE (#{moneyUserId}, #{moneyRescueName}, #{moneyUserName}, #{moneyIsAnonym}, #{moneyPrice}, #{moneyPhone}, #{moneyMessage}, #{moneyTime})")
    void addDonationMoney(DonationMoney donationMoney);

    @Select("select * from t_donation_material")
    List<DonationMaterial> getMaterialList();

    @Select("select * from t_donation_money")
    List<DonationMoney> getMoneyList();
}
