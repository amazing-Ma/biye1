package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.eneity.UserEduInfo;

import java.util.List;

public interface UserEduInfoMapper extends BaseMapper<UserEduInfo> {

    List<UserEduInfo> getInfo(String userid);
}
