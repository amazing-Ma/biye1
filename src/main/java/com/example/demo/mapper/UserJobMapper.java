package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.eneity.UserBaseInfo;

public interface UserJobMapper extends BaseMapper<UserBaseInfo> {
    UserBaseInfo getUserJobInfo(String userId);
}
