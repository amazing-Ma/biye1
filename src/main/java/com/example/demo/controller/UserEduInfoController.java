package com.example.demo.controller;

import com.example.demo.eneity.User;
import com.example.demo.eneity.UserEduInfo;
import com.example.demo.service.UserEduInfoService;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/eduInfo")
public class UserEduInfoController {
    @Autowired
    UserEduInfoService userEduInfoService;

    @GetMapping("/onload")
    public Result onload(String id){
       UserEduInfo userEduInfo = userEduInfoService.selectById(id);
        return Result.success(userEduInfo);
    }
    @PostMapping("saveOrUpdate")
    public Result update(@RequestBody UserEduInfo userEduInfo){
        userEduInfoService.saveOrUpdate(userEduInfo);
        return Result.success("success");
    }



}
