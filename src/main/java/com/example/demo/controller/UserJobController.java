package com.example.demo.controller;

import com.example.demo.VO.JobCreaterVO;
import com.example.demo.VO.JobRecord;
import com.example.demo.VO.JobRecordUserVO;
import com.example.demo.VO.PartTimeJobVO;
import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.UserBaseInfo;
import com.example.demo.eneity.UserJob;
import com.example.demo.service.PartTimeJobService;
import com.example.demo.service.UserJobService;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userJob")
public class UserJobController {

    @Autowired
    UserJobService userJobInfoService;
    @Autowired
    PartTimeJobService partTimeJobService;
    @Autowired
    UserJobService userJobService;

    @GetMapping("/onLoad")
    public Result onLoad(){
        String userId = UserUtils.getUserId();
        UserBaseInfo userJobInfo = new UserBaseInfo();
        try {
            userJobInfo = userJobInfoService.getInfo(userId);
        }catch (NullPointerException e) {
            return Result.failure(501, "当前无信息哦，请尽快补充");
        }
        return Result.success(userJobInfo);
    }
    @PostMapping("/update")
    public Result update(UserBaseInfo userJobInfo){
        userJobInfoService.updateById(userJobInfo);
        return Result.success("success");
    }
    @PostMapping("/add")
    public Result insert(UserBaseInfo userJobInfo){
        userJobInfoService.insery(userJobInfo);
        return Result.success("seccess");
    }
    /**
     * 新增兼职接口
     */
    @PostMapping("/newJob")
    public Result newJob(@RequestBody PartTimeJob partTimeJob){
        partTimeJobService.newJob(partTimeJob);
        return Result.success("success");
    }
    /**
     *正在审核兼职接口
     * 包含审核未通过
     */
    @GetMapping("/auditing")
    public Result auditingJpb(){
        List<PartTimeJob> list = partTimeJobService.auditingJob();
        return Result.success(list);
    }
    /**
     * 正在审核接口
     */
    @GetMapping("/auditingJob")
    public Result auditingJob(){
        List<PartTimeJob> list = partTimeJobService.aduiting();
        return Result.success(list);
    }
    /**
     * 审核未通过
     */
    @GetMapping("/failAuditing")
    public Result failAuditing(){
        List<PartTimeJob> list = partTimeJobService.failAuditing();
        return Result.success(list);
    }
    /**
     * 已发布兼职
     */
    @GetMapping("publishJob")
    public Result publishJob() throws  NullPointerException{
        List<PartTimeJob> list = partTimeJobService.publishJob();
        return Result.success(list);
    }
    /**
     * 申请兼职
     */
    @PostMapping("applyJob")
    public Result applyJob(@RequestBody PartTimeJobVO jobCreaterVO){
        userJobInfoService.apply(jobCreaterVO);
        return Result.success("success");
    }
    /**
     * 报名记录
     */
    @PostMapping("applyRecord")
    public  Result applyRecord(){
        List<JobRecord> jobRecord = userJobInfoService.getRecord(0);
        return Result.success(jobRecord);
    }
    @PostMapping("RecoedUser")
    public Result RecoedUser(@RequestBody String id){
        JobRecordUserVO jobRecordUserVO = userJobInfoService.getRecordUser(id);
        return Result.success(jobRecordUserVO);
    }
    /**
     * 同意报名是否
     */
    @PostMapping("recordState")
    public Result recordState(@RequestBody UserJob userJob){
        userJobService.recordState(userJob);
        return Result.success("success");
    }






}
