package com.seeing.utils;


import java.util.Date;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final long EXPIRE_TIME  = 15 * 60 * 1000;

    private static final String TOKEN_SECRET = "xqSeeing";
    /**
     *
     * @param id
     * @param phone
     * @return
     */
    public static String sign(Integer id , String phone){
        try {
            //设置过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            Map<String , Object> header = new HashMap<>(2);
            header.put("Type","Jwt");
            header.put("alg","HS256");

            String token =  JWT.create()
                    .withHeader(header)
                    .withClaim("id",id.toString())
                    .withClaim("phone",phone)
                    .withExpiresAt(date)
                    .sign(algorithm);
            //添加
            RedisUtil.setToken(token);
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检验token是否正确
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);

            //redis验证token
            return  RedisUtil.verifyToken(token);

        } catch (Exception e){
            return false;
        }

    }

    public static String getInfo(String token ,String type){

        try {
            DecodedJWT jwt = JWT.decode(token);
            if (type.equals("phone")) {
                return jwt.getClaim("phone").asString();
            }
            if (type.equals("id")) {
                return jwt.getClaim("id").asString();
            }

        } catch (JWTDecodeException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }


}
