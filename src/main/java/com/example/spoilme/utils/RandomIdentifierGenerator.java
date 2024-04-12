package com.example.spoilme.utils;

import java.util.Random;

/**
 * 分组ID生成器
 */
public class RandomIdentifierGenerator {

    // 生成指定长度的随机标识，包含指定数量的字母和数字
    public static String generateIdentifier(int totalLength, int letterLength) {
        StringBuilder identifier = new StringBuilder();
        Random random = new Random();

        // 计算数字和字母的长度
        int digitLength = totalLength - letterLength;

        // 生成随机字符
        for (int i = 0; i < totalLength; i++) {
            if (i < digitLength) {
                // 生成数字
                char digit = (char) (random.nextInt(10) + '0');
                identifier.append(digit);
            } else {
                // 生成字母
                char letter = (char) (random.nextInt(26) + 'a');
                identifier.append(letter);
            }
        }

        // 打乱顺序
        for (int i = totalLength - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = identifier.charAt(i);
            identifier.setCharAt(i, identifier.charAt(j));
            identifier.setCharAt(j, temp);
        }

        return identifier.toString();
    }

    // 生成随机标识
    public static String generateIdentifier() {
        int length = 6;
        StringBuilder identifier = new StringBuilder();
        Random random = new Random();

        // 生成随机字符
        for (int i = 0; i < length; i++) {
            int type = random.nextInt(2); // 0代表数字，1代表字母
            if (type == 0) {
                char digit = (char) (random.nextInt(10) + '0');
                identifier.append(digit);
            } else {
                char letter = (char) (random.nextInt(26) + 'a');
                identifier.append(letter);
            }
        }

        return identifier.toString();
    }

    public static String generateGroupID() {
        return generateIdentifier();
    }
}
