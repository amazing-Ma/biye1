package com.example.demo.controller;

import com.example.demo.eneity.User;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping("/test1")
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/test")
    public String test(){
        System.out.println("success");
        return "hello wprld";
    }

    @GetMapping("/hello")
    public String hello() {
        String userId  = UserUtils.getUserId();
        System.out.println(userId);
        return "hello world";
    }


    @GetMapping("/test/userInfo")
    public Result getUser() {
        User user = new User();
        user.setUserName("马海龙");
        user.setUserPasswd("12345678901");
        return Result.success(user);
    }
    @GetMapping("/redis")
    public void A() throws InterruptedException {
//插入单条数据
        redisTemplate.opsForValue().set("key1", "new message");
        System.out.println(redisTemplate.opsForValue().get("key1"));
//插入单条数据（存在有效期）
        System.out.println("-----------------");
        redisTemplate.opsForValue().set("key2", "这是一条会过期的信息", 1, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
        System.out.println(redisTemplate.hasKey("key2"));//检查key是否存在，返回boolean值
        System.out.println(redisTemplate.opsForValue().get("key2"));
        Thread.sleep(2000);
        System.out.println(redisTemplate.hasKey("key2"));//检查key是否存在，返回boolean值
        System.out.println(redisTemplate.opsForValue().get("key2"));
        System.out.println("-----------------");

    }




}
