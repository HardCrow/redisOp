package com.testredis.demo.demos.web;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;
//早期连接redis
public class jedisDome {
    public static void main(String[] args) {
        //记得centos的ifconfig中的en33的ip地址要和本地cmd ipconfig的ip地址其中一个  同网段
        //不然连接不上
        //连接前可以在cmd里面测试连通性 直接ping就行
        Jedis jedis = new Jedis("192.254.70.10",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        Set<String> ks=jedis.keys("*");
        System.out.println(ks);
        jedis.set("k3","123");
        System.out.println(jedis.get("k3"));
        jedis.lpush("list","11111111");
        jedis.lpush("list","1111111sss1");
        List<String> list =jedis.lrange("list",0,-1);
        for(String element:list){
            System.out.println(element);
        }
    }
}
