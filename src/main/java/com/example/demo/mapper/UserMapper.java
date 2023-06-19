package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.eneity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User findUser(@Param("user") User user);

    User findById(String id);
    List<String>  getUserId(@Param("jobId") String jobId);

    List<User> getAll();
}
