package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.VO.JobCreaterVO;
import com.example.demo.VO.PartTimeJobVO;
import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.Query;
import com.example.demo.service.PartTimeJobService;
import com.example.demo.utils.UserUtils;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/partTimeJob")
public class PartTimeJobController {

    @Autowired
    PartTimeJobService partTimeJobService;

    /**
     * 显示兼职以及信息
     */
    @PostMapping("onLoad")
        public Result onLoad(@RequestBody PartTimeJob partTimeJob, Query query){
        IPage<PartTimeJob> list = partTimeJobService.onLoad(partTimeJob,query);
        return Result.success(list);
    }

    @PostMapping("getList")
    public Result getLsit(@RequestBody PartTimeJob partTimeJob){
        List<PartTimeJob> list = partTimeJobService.getJob(partTimeJob);
        return Result.success(list);
    }
    @PostMapping("getJobDetail")
    public Result getDetail(@RequestBody  String id){
        PartTimeJobVO partTimeJobVO = partTimeJobService.getDetail(id);
        return Result.success(partTimeJobVO);
    }
    @PostMapping("/getCreaterDetail")
    public Result getCreaterDetail(@RequestBody String id){
        JobCreaterVO jobCreaterVO = partTimeJobService.getCreaterDetail(id);
        return Result.success(jobCreaterVO);

    }
}
