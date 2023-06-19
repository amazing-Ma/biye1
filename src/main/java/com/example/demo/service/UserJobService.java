package com.example.demo.service;

import com.example.demo.VO.JobCreaterVO;
import com.example.demo.VO.JobRecord;
import com.example.demo.VO.JobRecordUserVO;
import com.example.demo.VO.PartTimeJobVO;
import com.example.demo.eneity.UserBaseInfo;
import com.example.demo.eneity.UserJob;

import java.util.List;

public interface UserJobService {
    UserBaseInfo getInfo(String userId);

    void updateById(UserBaseInfo userJobInfo);

    void insery(UserBaseInfo userJobInfo);

    void apply(PartTimeJobVO jobCreaterVO);

    List<JobRecord> getRecord(int receiveState);

    JobRecordUserVO getRecordUser(String id);

    void recordState(UserJob userJob);

}
