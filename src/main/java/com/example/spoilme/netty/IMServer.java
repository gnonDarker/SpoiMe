package com.example.spoilme.netty;


import com.example.spoilme.netty.handler.WebSocketHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class IMServer {
    @Value("${netty.socket.port}")
    private Integer port;

    public static final Map<String, Channel> ONLINE=new ConcurrentHashMap<>(1024);

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workGroup = new NioEventLoopGroup();

    public void start(){
        //绑定端口
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(this.bossGroup,this.workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //添加HTTP编解码器
                        pipeline.addLast(new HttpServerCodec())
                                //支持大数据流
                                .addLast(new ChunkedWriteHandler())
                                //对HTTP消息做聚合操作，FullHttpRequest、FullHttpResponse
                                .addLast(new HttpObjectAggregator(1024*64))
                                //websocket
                                .addLast(new WebSocketServerProtocolHandler("/"))
                                //
                                .addLast(new WebSocketHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.bind(port).sync();
            log.info("服务器启动开始监听端口: {}", port);
            future.channel().closeFuture().sync();
            if (future.isSuccess()) {
                log.info("启动 Netty Server");
            }
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        this.bossGroup.shutdownGracefully();
        this.workGroup.shutdownGracefully();
        log.info("关闭Netty");
    }
}
