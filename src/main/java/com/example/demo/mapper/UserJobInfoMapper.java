package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.eneity.UserJobInfo;

import java.util.List;

public interface UserJobInfoMapper extends BaseMapper<UserJobInfo> {

    List<UserJobInfo> getInfo(String userId);
}
