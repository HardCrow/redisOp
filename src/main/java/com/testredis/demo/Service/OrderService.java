package com.testredis.demo.Service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service

public class OrderService {
    public static  final  String ORDER_KEY="ord:";
    @Resource
    private RedisTemplate RedisTemplate;
    public void addOrder(){
        int keyId = ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo = UUID.randomUUID().toString();
        String key =ORDER_KEY+keyId;
        String value ="我的订单" +serialNo;
        RedisTemplate.opsForValue().set(key,value);
        System.out.println(key);
        System.out.println(value);
    }
    public  String getOrderById(Integer keyId){
        return (String) RedisTemplate.opsForValue().get(ORDER_KEY+keyId);
    }

}
