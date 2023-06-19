package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.VO.JobCreaterVO;
import com.example.demo.VO.PartTimeJobVO;
import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.Query;

import java.util.List;

public interface PartTimeJobService extends IService<PartTimeJob> {

    void newJob(PartTimeJob partTimeJob);

    /**
     * 正在审核所有
     */
    List<PartTimeJob> auditingJob();
    /**
     * 正在审核
     */
    List<PartTimeJob> aduiting();
    /**
     * 审核未通过
     */
    List<PartTimeJob> failAuditing();
    /**
     * 审核通过已经发布以及失效
     */
    List<PartTimeJob> publishJob();
    /**
     * 显示兼职
     */
    IPage<PartTimeJob> onLoad(PartTimeJob partTimeJob , Query query);
    /**
     * 显示兼职-不分页
     */
    List<PartTimeJob> getJob(PartTimeJob partTimeJob);
    /**
     * 获取兼职信息以及发布者信息
     */
    PartTimeJobVO getDetail(String id);
    /**
     * 获取发布机构详情
     */

    JobCreaterVO getCreaterDetail(String id);



}
