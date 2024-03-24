package com.example.spoilme.netty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage implements Serializable {
    //消息类型
    private Integer type;
    private Integer userId;
    private String nickName;
    //目标接收对象
    private Integer targetId;
    //内容
    private String content;
    //发送时间
    private Date time;
}
