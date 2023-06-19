package com.example.demo.controller;

import com.example.demo.VO.UserBaseInfoVO;
import com.example.demo.eneity.UserBaseInfo;
import com.example.demo.service.UserBaseInfoService;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userBaseInfo")
public class UserBaseInfoController {

    @Autowired
    UserBaseInfoService userBaseInfoService;

    @GetMapping("/onload")
    public Result onload(){
        String userId = UserUtils.getUserId();
        UserBaseInfoVO userBaseInfoVO = userBaseInfoService.onload(userId);
        if(userBaseInfoVO == null){
            return Result.failure(500,"当前无信息，请尽快添加");
        }
        return Result.success(userBaseInfoVO);
    }
    @PostMapping("saveOrUpload")
    public Result saveOrUpload(@RequestBody UserBaseInfo userBaseInfo){
        userBaseInfoService.saveOrUpdate(userBaseInfo);
        return Result.success("success");
    }
    @GetMapping("list")
    public Result list(){
        UserBaseInfo userBaseInfo = userBaseInfoService.list();
        if(userBaseInfo == null){
            return Result.failure(500,"当前无信息请尽快添加");
        }
        return Result.success(userBaseInfo);
    }
    @PostMapping("recordUserInfo")
    public Result recordUserInfo(@RequestBody String userId){
        UserBaseInfoVO userBaseInfoVO = userBaseInfoService.onload(userId);
        if(userBaseInfoVO == null){
            return Result.failure(500,"当前无信息");
        }
        return Result.success(userBaseInfoVO);


    }



}
