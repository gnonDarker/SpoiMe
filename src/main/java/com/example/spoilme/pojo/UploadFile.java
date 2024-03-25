package com.example.spoilme.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_file")
public class UploadFile {
    private String id;
    @TableField(value = "file_name")
    private String fileName;
    private String url;
    @TableField(value = "upload_time")
    private Date uploadTime;
}
