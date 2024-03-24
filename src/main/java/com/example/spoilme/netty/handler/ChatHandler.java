package com.example.spoilme.netty.handler;

import com.alibaba.fastjson2.JSON;
import com.example.spoilme.netty.ChatMessage;
import com.example.spoilme.netty.MessageType;
import com.example.spoilme.pojo.Result;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class ChatHandler {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    public void execute(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame){
        try{
            ChatMessage chatMessage = JSON.parseObject(textWebSocketFrame.text(), ChatMessage.class);
            switch (MessageType.match(chatMessage.getType())){
                case CONNETION -> {
                    //TODO
                    //用户上线存入redis
                    System.out.println("user:" + chatMessage.getUserId()+" 上线");
                    if(Boolean.TRUE.equals(redisTemplate.hasKey("user:" + chatMessage.getUserId()))) {
                        channelHandlerContext.channel().writeAndFlush(Result.error("重复连接"));
                    }
                    redisTemplate.opsForValue().set("user:"+chatMessage.getUserId(),channelHandlerContext.channel());
                    //读取redis 查看是否有离线消息
                    Set<String> keys = redisTemplate.keys("message:*");
                    if(keys == null || keys.isEmpty()){
                        channelHandlerContext.channel().writeAndFlush(Result.success("连接成功"));
                    }
                    List<ChatMessage> chatMessages = new ArrayList<>();
                    for (String key : keys){
                        chatMessages.add(JSON.parseObject(key, ChatMessage.class));
                    }
                    redisTemplate.delete(keys);
                    channelHandlerContext.channel().writeAndFlush(Result.success(chatMessages));
                }
                case PRIVATE -> {
                    if(chatMessage.getTargetId()!=null){
                        //TODO
                        //读取redis 目标对象是否在线
                        Channel targetChannel = (Channel)redisTemplate.opsForValue().get("user:"+chatMessage.getTargetId());
                        //不在线，将消息存入redis中
                        if(targetChannel == null || !targetChannel.isActive()){
                            redisTemplate.opsForValue().set("message:"+chatMessage.getTime()+":"+chatMessage.getTargetId(),chatMessage);
                            return;
                        }
                        //在线直接推送消息
                        targetChannel.writeAndFlush(Result.success(chatMessage));
                    }else {
                        channelHandlerContext.channel().writeAndFlush(Result.error("发送对象不存在"));
                    }
                }
                case ERROR -> channelHandlerContext.channel().writeAndFlush(Result.error("不支持的消息格式"));
            }
        }catch (Exception e){
            channelHandlerContext.channel().writeAndFlush(Result.error("发送消息格式有误"));
        }
    }
}
