package com.example.demo.service.serviceImpl;

import com.example.demo.eneity.UserEduInfo;
import com.example.demo.mapper.UserEduInfoMapper;
import com.example.demo.service.UserEduInfoService;
import com.example.demo.utils.UserUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEduInfoServiceImpl implements UserEduInfoService {
    @Resource
    UserEduInfoMapper userEduInfoMapper;

    @Override
    public UserEduInfo selectById(String id) {
        return userEduInfoMapper.selectById(id);
    }

    @Override
    public void saveOrUpdate(UserEduInfo userEduInfo) {
        if(userEduInfo.getId() == null || userEduInfo.getId().equals("")){
            String userId = UserUtils.getUserId();
            userEduInfo.setUserId(Long.valueOf(userId));
            userEduInfoMapper.insert(userEduInfo);
        }else {
            userEduInfoMapper.updateById(userEduInfo);
        }
    }
}
