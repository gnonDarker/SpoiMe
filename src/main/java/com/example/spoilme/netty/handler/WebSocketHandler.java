package com.example.spoilme.netty.handler;

import com.alibaba.fastjson2.JSON;
import com.example.spoilme.netty.ChatMessage;
import com.example.spoilme.netty.IMServer;
import com.example.spoilme.netty.MessageType;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.UserService;
import com.example.spoilme.utils.ChannelUtils;
import com.example.spoilme.utils.SpringUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;

@Sharable
@Slf4j
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private RedisTemplate<String,Object> redisTemplate;
    public WebSocketHandler(){
        redisTemplate=new RedisTemplate<>();
        LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory();
        lettuceConnectionFactory.setHostName("127.0.0.1");
        lettuceConnectionFactory.setPassword("lxz2100301322@");
        lettuceConnectionFactory.setPort(6379);
        lettuceConnectionFactory.start();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        // 设置key序列化方式string，RedisSerializer.string() 等价于 new StringRedisSerializer()
        redisTemplate.setKeySerializer(RedisSerializer.string());
        // 设置value的序列化方式json，使用GenericJackson2JsonRedisSerializer替换默认序列化，RedisSerializer.json() 等价于 new GenericJackson2JsonRedisSerializer()
        redisTemplate.setValueSerializer(RedisSerializer.json());
        // 设置hash的key的序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        // 设置hash的value的序列化方式
        redisTemplate.setHashValueSerializer(RedisSerializer.json());
        // 使配置生效
        redisTemplate.afterPropertiesSet();
    }


    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        ChatMessage chatMessage = JSON.parseObject(textWebSocketFrame.text(), ChatMessage.class);
        chatMessage.setTime(new Date());
        switch (MessageType.match(chatMessage.getType())){
            case CONNETION -> {
                Channel channel = IMServer.ONLINE.get("user:"+chatMessage.getUserId());
                if(channel == null || !channel.isActive()){
                    IMServer.ONLINE.put("user:"+chatMessage.getUserId(), channelHandlerContext.channel());
                    channelHandlerContext.channel().writeAndFlush(Result.success("连接成功").toJsonString());
                }else {
                    channelHandlerContext.channel().writeAndFlush(Result.error("重复连接").toJsonString());
                }
                log.info(IMServer.ONLINE.toString());
            }
            case MESSAGE -> {
                //读取redis 查看是否有离线消息
                Set<String> keys = redisTemplate.keys("message:"+chatMessage.getUserId()+"*");
                if(keys == null || keys.isEmpty()){
                    channelHandlerContext.channel().writeAndFlush(Result.success("无新消息").toJsonString());
                }else {
                    List<ChatMessage> chatMessages = redisTemplate.opsForValue().multiGet(keys).stream().map(item -> (ChatMessage) item).collect(Collectors.toList());
                    redisTemplate.delete(keys);
                    channelHandlerContext.channel().writeAndFlush(Result.success(chatMessages).toJsonString());
                }
            }
            case PRIVATE -> {
                if(chatMessage.getTargetId()!=null){
                    //判断 目标对象是否在线
                    Channel targetChannel = IMServer.ONLINE.get("user:"+chatMessage.getTargetId());
                    //不在线，将消息存入redis中
                    if(targetChannel == null || !targetChannel.isActive()){
                        //TODO
                        //查询数据库目标对象是否存在
                        redisTemplate.opsForValue().set("message:"+chatMessage.getTargetId()+":"+ UUID.randomUUID().toString().replace("-",""),chatMessage);
                        channelHandlerContext.channel().writeAndFlush(Result.success("发送成功，对方不在线转入离线消息").toJsonString());
                    }else {
                        //在线直接推送消息
                        targetChannel.writeAndFlush(Result.success(chatMessage).toJsonString());
                        channelHandlerContext.channel().writeAndFlush(Result.success("发送成功").toJsonString());
                    }
                }else {
                    channelHandlerContext.channel().writeAndFlush(Result.error("发送对象不存在").toJsonString());
                }
            }
            case ERROR -> channelHandlerContext.channel().writeAndFlush(Result.error("不支持的消息格式").toJsonString());
        }
    }
}
