package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.Query;
import com.example.demo.eneity.UserComplaint;
import com.example.demo.mapper.UserComplaintMapper;
import com.example.demo.service.UserComplaintService;
import org.springframework.stereotype.Service;

@Service
public class UserComplaintServiceImpl extends ServiceImpl<UserComplaintMapper, UserComplaint> implements UserComplaintService{
    @Override
    public IPage<UserComplaint> onload(UserComplaint userComplaint, Query query) {
        IPage<UserComplaint> page = new Page<>(query.getCurrentPage(), query.getPageSize());
        QueryWrapper<UserComplaint> queryWrapper = new QueryWrapper<>();
        if(userComplaint.getComplaintType() != null && !userComplaint.getComplaintType().equals("")){
            queryWrapper.like("complaint_type",userComplaint.getComplaintType());
        }
        if(userComplaint.getComplaintTitle()!=null&& !userComplaint.getComplaintTitle().equals("")){
            queryWrapper.like("complaint_title",userComplaint.getComplaintTitle());
        }if(userComplaint.getUserId()!=null&&!userComplaint.getUserId().equals("")){
            queryWrapper.eq("user_id",userComplaint.getUserId());
        }if(userComplaint.getIsSend()!=null && !userComplaint.getIsSend().equals("")){
            queryWrapper.eq("is_send",userComplaint.getIsSend());
        }
        queryWrapper.eq("is_deleted",0);
        IPage<UserComplaint> list = baseMapper.selectPage(page,queryWrapper);
        System.out.println(list);
        return list;
    }
}
