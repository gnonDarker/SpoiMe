package com.example.spoilme.pojo;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    //统一相应结果
    private Integer code;//响应码
    private String msg;//响应信息
    private Object data; //响应数据
    public static Result success(){
        //增删改 成功
        return new Result(200,"success",null);
    }
    public static Result success(String msg){
        //增删改 成功
        return new Result(200,msg,null);
    }
    public static Result success(Object data){
        //查询 成功
        return new Result(200,"success", data);
    }
    public static Result error(String msg){
        //失败响应
        return new Result(300,msg,null);
    }
    public TextWebSocketFrame toJsonString(){
        return new TextWebSocketFrame(JSON.toJSONString(this));
    }
}
