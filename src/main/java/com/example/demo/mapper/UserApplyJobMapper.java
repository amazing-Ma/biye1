package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.VO.JobRecord;
import com.example.demo.eneity.User;
import com.example.demo.eneity.UserJob;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface UserApplyJobMapper extends BaseMapper<UserJob> {

    UserJob getJob(@Param("userId") String userId, @Param("jobId") String jobId);

    List<JobRecord> getRecord(@Param("receiveState")int receivState, @Param("userId") String userId);

    List<User> getJobRecordUser(@Param("userId") List<String> userId);

    UserJob getUserJob(UserJob userJob);
}
