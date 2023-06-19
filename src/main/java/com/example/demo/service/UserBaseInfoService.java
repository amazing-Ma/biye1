package com.example.demo.service;

import com.example.demo.VO.UserBaseInfoVO;
import com.example.demo.eneity.UserBaseInfo;

public interface UserBaseInfoService {
    UserBaseInfoVO onload(String userId);

    void saveOrUpdate(UserBaseInfo userBaseInfo);

    UserBaseInfo list();
}
