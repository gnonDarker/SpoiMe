package com.example.spoilme.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("t_conserve")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conserve {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务方式
     */
    private String serveType;

    /**
     * 地址
     */
    private String address;

    /**
     * 服务内容
     */
    private String content;

    /**
     * 服务站id
     */
    private Integer rescueId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 分类id
     */
    private String gid;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 删除标识 0：未删除 1：已删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;

    /**
     * 救助站信息
     */
    @TableField(exist = false)
    private RescueStation rescueStation;
}
