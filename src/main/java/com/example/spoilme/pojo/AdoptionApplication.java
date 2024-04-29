package com.example.spoilme.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_application")
public class AdoptionApplication implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * real_name
     */
    private String realName;

    /**
     * sex
     */
    private String sex;

    /**
     * age
     */
    private Integer age;

    /**
     * wx
     */
    private String wx;

    /**
     * address
     */
    private String address;

    /**
     * phone
     */
    private String phone;

    /**
     * mail
     */
    private String mail;

    /**
     * 工作情况
     */
    private String work;

    /**
     * 工作性质
     */
    private String jobNature;

    /**
     * 出差/出游频率
     */
    private String btFrequency;

    /**
     * 如需出差/出游
     */
    private String bt;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 目前一起居住的人
     */
    private String liveTogether;

    /**
     * 是否和他们沟通过领养事宜
     */
    private String liveTogetherKnow;

    /**
     * 了解怀孕期间养宠物的影响
     */
    private String influencePregnancyKnow;

    /**
     * 住房面积
     */
    private String livingSpace;

    /**
     * 是否养过或正在宠物
     */
    private String petRearing;

    /**
     * 请描述它的情况
     */
    @TableField(value = "`condition`")
    private String condition;

    /**
     * 是否了解打疫苗的相关事宜
     */
    private String vaccine;

    /**
     * 用过或听过的猫粮、狗粮品牌
     */
    private String petFood;

    /**
     * 最近的宠物医院距离
     */
    private String nearestPetHospital;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 失败理由
     */
    private String cause;

    /**
     * 删除标识
     */
    private Integer delFlag;
}
