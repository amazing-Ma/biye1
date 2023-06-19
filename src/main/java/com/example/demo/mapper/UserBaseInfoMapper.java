package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.VO.UserBaseInfoVO;
import com.example.demo.eneity.UserBaseInfo;

public interface UserBaseInfoMapper extends BaseMapper<UserBaseInfo> {

    UserBaseInfo getInfo(String userId);
}
