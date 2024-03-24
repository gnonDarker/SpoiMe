package com.example.spoilme.utils;

import io.netty.channel.Channel;

import java.io.*;

public class ChannelUtils {
    public static byte[] toByte(Channel channel) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(channel);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public static Channel toChannel(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Channel) ois.readObject();
    }
}
