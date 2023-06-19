package com.example.demo.service;

import com.example.demo.eneity.UserJobInfo;

import java.util.List;

public interface UserJobInfoService {
    List<UserJobInfo> getInfo(String userId);
    void saveOrUpdate(UserJobInfo userJobInfo);
}
