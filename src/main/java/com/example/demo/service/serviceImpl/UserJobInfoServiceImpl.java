package com.example.demo.service.serviceImpl;

import com.example.demo.eneity.UserJobInfo;
import com.example.demo.mapper.UserJobInfoMapper;
import com.example.demo.service.UserJobInfoService;
import com.example.demo.utils.UserUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserJobInfoServiceImpl implements UserJobInfoService {
    @Resource
    UserJobInfoMapper userJobInfoMapper;

    @Override
    public List<UserJobInfo> getInfo(String userId) {
        List<UserJobInfo> jobInfos = userJobInfoMapper.getInfo(userId);
        return jobInfos;
    }

    @Override
    public void saveOrUpdate(UserJobInfo userJobInfo) {
        String userId = UserUtils.getUserId();
        userJobInfo.setUserId(Long.valueOf(userId));
        if(userJobInfo.getId() == null || userJobInfo.getId().equals("")){
            userJobInfoMapper.insert(userJobInfo);
        }else {
            userJobInfoMapper.updateById(userJobInfo);
        }
    }
}
