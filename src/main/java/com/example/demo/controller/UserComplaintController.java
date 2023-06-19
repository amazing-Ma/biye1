package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.eneity.Query;
import com.example.demo.eneity.UserComplaint;
import com.example.demo.service.MyMailService;
import com.example.demo.service.UserComplaintService;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/complaint")
public class UserComplaintController {

    @Autowired
    UserComplaintService userComplaintService;
    @Autowired
    MyMailService myMailService;


    @PostMapping("/save")
    public Result save(@RequestBody UserComplaint userComplaint){
        String userId = UserUtils.getUserId();
        userComplaint.setUserId(Long.valueOf(userId));
        userComplaintService.save(userComplaint);
        return Result.success("已成功申诉，我们会将结果通过邮件的形式发给您");
    }
    @PostMapping("/sendMail")
    public void sendMail(@RequestBody SimpleMailMessage simpleMailMessage){
       myMailService.sendMail(simpleMailMessage);
    }
    @PostMapping("onLoad")
    public Result onload(@RequestBody UserComplaint userComplaint, Query query){
       IPage<UserComplaint> page = userComplaintService.onload(userComplaint,query);
       return Result.success(page);
    }




}
