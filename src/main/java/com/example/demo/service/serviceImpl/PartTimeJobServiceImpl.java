package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.VO.JobCreaterVO;
import com.example.demo.VO.PartTimeJobVO;
import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.Query;
import com.example.demo.eneity.User;
import com.example.demo.eneity.UserJob;
import com.example.demo.mapper.PartTimeJobMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.PartTimeJobService;
import com.example.demo.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PartTimeJobServiceImpl extends ServiceImpl<PartTimeJobMapper,PartTimeJob> implements PartTimeJobService{
    @Resource
    PartTimeJobMapper partTimeJobMapper;
    @Resource
    UserMapper userMapper;
    @Override
    public void newJob(PartTimeJob partTimeJob) {
        String userId = UserUtils.getUserId();
        partTimeJob.setJobCreater(Long.valueOf(userId));
        partTimeJob.setCurrentProgress(0);
        partTimeJobMapper.insert(partTimeJob);
    }

    @Override
    public List<PartTimeJob> auditingJob() throws NullPointerException{
        String userId = UserUtils.getUserId();
        QueryWrapper<PartTimeJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_creater",userId).in("current_progress",0,1).eq("is_deleted",0);
        List<PartTimeJob> list = partTimeJobMapper.selectList(queryWrapper);
        return list;

    }

    @Override
    public List<PartTimeJob> aduiting() throws NullPointerException {
        String userId = UserUtils.getUserId();
        QueryWrapper<PartTimeJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_creater",userId).eq("current_progress",0).eq("is_deleted",0);
        List<PartTimeJob> list = partTimeJobMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public List<PartTimeJob> failAuditing() throws NullPointerException {
        String userId = UserUtils.getUserId();
        QueryWrapper<PartTimeJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_creater",userId).eq("current_progress",1).eq("is_deleted",0);
        List<PartTimeJob> list = partTimeJobMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public List<PartTimeJob> publishJob() throws  NullPointerException{
        String userId = UserUtils.getUserId();
        QueryWrapper<PartTimeJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("job_creater",userId).eq("current_progress",2).eq("is_deleted",0);
        List<PartTimeJob> list = baseMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public IPage<PartTimeJob> onLoad(PartTimeJob partTimeJob, Query query) {
        IPage<PartTimeJob> page = new Page<>(query.getCurrentPage(), query.getPageSize());
        QueryWrapper<PartTimeJob> queryWrapper = new QueryWrapper();
        if(partTimeJob.getTitle() != null && !partTimeJob.getTitle().equals("")){
            queryWrapper.like("title",partTimeJob.getTitle());
        }
        if(partTimeJob.getJobType()!= null && !partTimeJob.getJobType().equals("")){
            queryWrapper.eq("job_type",partTimeJob.getJobType());
        }
        if(partTimeJob.getGenderType() != null && !partTimeJob.getGenderType().equals("")){
            queryWrapper.eq("gender_type",partTimeJob.getGenderType());
        }
        queryWrapper.eq("is_deleted",0);
        IPage<PartTimeJob> list = baseMapper.selectPage(page,queryWrapper);
        return list;
    }

    @Override
    public List<PartTimeJob> getJob(PartTimeJob partTimeJob) {
        QueryWrapper<PartTimeJob> queryWrapper = new QueryWrapper();
        if(partTimeJob.getTitle() != null && !partTimeJob.getTitle().equals("")){
            queryWrapper.like("title",partTimeJob.getTitle());
        }
        if(partTimeJob.getJobType()!= null && !partTimeJob.getJobType().equals("")){
            queryWrapper.eq("job_type",partTimeJob.getJobType());
        }
        if(partTimeJob.getGenderType() != null && !partTimeJob.getGenderType().equals("")){
            queryWrapper.eq("gender_type",partTimeJob.getGenderType());
        }
        queryWrapper.eq("is_deleted",0);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PartTimeJobVO getDetail(String id) {
        PartTimeJobVO partTimeJobVO = new PartTimeJobVO();
        PartTimeJob partTimeJob = partTimeJobMapper.selectById(id);
        BeanUtils.copyProperties(partTimeJob,partTimeJobVO);
        User user = userMapper.selectById(partTimeJob.getJobCreater());
        partTimeJobVO.setUserName(user.getUserName());
        int nums = partTimeJobMapper.getJobCountInt(user.getId());
        partTimeJobVO.setJobNumber(nums);
        return partTimeJobVO;
    }

    @Override
    public JobCreaterVO getCreaterDetail(String id) {
        JobCreaterVO jobCreaterVO = new JobCreaterVO();
        User user = userMapper.selectById(id);
        BeanUtils.copyProperties(user,jobCreaterVO);
        List<PartTimeJob> list = partTimeJobMapper.getJobByCreater(id);
        jobCreaterVO.setPartTimeJobList(list);
        int nums = partTimeJobMapper.getJobCountInt(Long.valueOf(id));
        jobCreaterVO.setJobNumber(nums);
        return jobCreaterVO;
    }
}

