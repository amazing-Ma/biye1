package com.example.demo.controller;

import com.example.demo.eneity.UserJobInfo;
import com.example.demo.service.UserJobInfoService;
import com.example.demo.service.UserJobService;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/jobInfo")
public class UserJobInfoController {
    @Autowired
    UserJobInfoService userJobInfoService;

    @GetMapping("/onload")
    public Result onload(){
        String userId = UserUtils.getUserId();
        return Result.success();
    }
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody UserJobInfo userJobInfo){
        userJobInfoService.saveOrUpdate(userJobInfo);
        return Result.success("success");
    }
}
