package com.example.spoilme.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    final private static String signKey = "spoilme"; //签名
    final private static Long expire = 8640000L; //24小时过期

    /*
     * 生成JWT令牌
     * @param claims 有效载荷信息
     * @return
     */

    //TODO 根据Map对象生成Token
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /*
     * TODO: 根据Token生成新的Token*/
    public static String generateJwt(String token){
        Map<String, Object> claims = new HashMap<>();
        claims.put("项目作者：","njl/lzd/ltj/xrj");
        return JwtUtils.generateJwt(claims);
    }
    /*
     * TODO: 解析JWT令牌, 解析失败会抛出异常
     * @param: jwt JWT令牌
     * @return: 有效载荷
     * */
    public static Claims parseJWT(String jwt){
        Claims claims =  Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}