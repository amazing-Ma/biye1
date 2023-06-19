package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.eneity.Query;
import com.example.demo.eneity.UserComplaint;

public interface  UserComplaintService extends IService<UserComplaint> {
    IPage<UserComplaint> onload(UserComplaint userComplaint, Query query);
}
