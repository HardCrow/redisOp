package com.testredis.demo.demos.web;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;
import java.util.Set;
//中期连接redis
public class lettuce {
    public static void main(String[] args) {
        //builder RedisURI
        RedisURI builder = RedisURI.builder()
                .redis("192.254.70.10").withPort(6379)
                .withAuthentication("default","123456").build();
        //创建连接客户端
        RedisClient redisClient = RedisClient.create(builder);
        StatefulRedisConnection<String, String> connect = redisClient.connect();
        //创建操作的command
        RedisCommands<String, String> commands = connect.sync();
        //关闭各种资源
        List key =commands.keys("*");
        System.out.println(key);
        connect.close();
        redisClient.shutdown();



    }
}
