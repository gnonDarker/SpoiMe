package com.example.spoilme.netty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageType {
    CONNETION(1001),PRIVATE(1),GROUP(2),ERROR(-1),MESSAGE(3);
    private Integer type;
    public static MessageType match(Integer type){
        for (MessageType value : MessageType.values()) {
            if(value.getType().equals(type)){
                return value;
            }
        }
        return ERROR;
    }
}
