package com.seeing.utils;

import com.google.gson.internal.$Gson$Preconditions;
import redis.clients.jedis.Jedis;

public class RedisUtil {

    private  static Jedis jedis = new Jedis();

    private static void init() {
        jedis = new Jedis("106.14.32.152",6379);
        jedis.auth(PropertiesUtil.getProperties("redis.password"));
    }


    public static boolean setToken( String token){
        init();
        try {
            jedis.sadd("token",token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    protected static boolean verifyToken(String token){
        init();
        return  jedis.sismember("token",token);
    }

    public static boolean setCode(String phone , String code){
        init();
        try {
            jedis.set(phone,code);
            jedis.expire(phone,60*5);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static String getCode(String phone){
        init();
        return jedis.get(phone);
    }

}
