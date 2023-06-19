package com.example.demo.service;

import com.example.demo.eneity.UserEduInfo;

public interface UserEduInfoService {

    UserEduInfo selectById(String id);

    void saveOrUpdate(UserEduInfo userEduInfo);
}
