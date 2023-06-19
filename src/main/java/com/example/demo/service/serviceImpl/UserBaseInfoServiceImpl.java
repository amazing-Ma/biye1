package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.VO.UserBaseInfoVO;
import com.example.demo.eneity.UserBaseInfo;
import com.example.demo.eneity.UserEduInfo;
import com.example.demo.eneity.UserJobInfo;
import com.example.demo.mapper.UserBaseInfoMapper;
import com.example.demo.mapper.UserEduInfoMapper;
import com.example.demo.mapper.UserJobInfoMapper;
import com.example.demo.service.UserBaseInfoService;
import com.example.demo.utils.UserUtils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
    @Resource
    UserBaseInfoMapper userBaseInfoMapper;
    @Resource
    UserEduInfoMapper userEduInfoMapper;
    @Resource
    UserJobInfoMapper userJobInfoMapper;
    
    @Override
    public UserBaseInfoVO onload(String userId) throws NullPointerException {
        UserBaseInfoVO userBaseInfoVO = new UserBaseInfoVO();
        try{
            UserBaseInfo userBaseInfo = userBaseInfoMapper.getInfo(userId);
            List<UserEduInfo> list = userEduInfoMapper.getInfo(userId);
            List<UserJobInfo> jobInfos = userJobInfoMapper.getInfo(userId);
            BeanUtils.copyProperties(userBaseInfo,userBaseInfoVO);
            userBaseInfoVO.setUserEduInfos(list);
            userBaseInfoVO.setUserJobInfos(jobInfos);
        }catch (Exception e){
            return null;
        }
        return userBaseInfoVO;
    }

    @Override
    public void saveOrUpdate(UserBaseInfo userBaseInfo) {
        String userId = UserUtils.getUserId();
        userBaseInfo.setUserId(Long.valueOf(userId));
        if(userBaseInfo.getId() == null || userBaseInfo.getId().equals("")){
            userBaseInfoMapper.insert(userBaseInfo);
        }else {
            userBaseInfoMapper.updateById(userBaseInfo);
        }
    }

    @Override
    public UserBaseInfo list() {
        String userId = UserUtils.getUserId();
        QueryWrapper<UserBaseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("is_deleted",0);
        UserBaseInfo userBaseInfo = userBaseInfoMapper.selectOne(queryWrapper);
        System.out.println(userBaseInfo.getId());
        return userBaseInfo;
    }

}
