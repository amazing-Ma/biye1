package com.example.demo.service.serviceImpl;

import com.example.demo.VO.JobCreaterVO;
import com.example.demo.VO.JobRecord;
import com.example.demo.VO.JobRecordUserVO;
import com.example.demo.VO.PartTimeJobVO;
import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.User;
import com.example.demo.eneity.UserBaseInfo;
import com.example.demo.eneity.UserJob;
import com.example.demo.mapper.PartTimeJobMapper;
import com.example.demo.mapper.UserApplyJobMapper;
import com.example.demo.mapper.UserJobMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserJobService;
import com.example.demo.utils.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserJobServiceImpl implements UserJobService {
    @Resource
    UserJobMapper userJobMapper;
    @Resource
    UserApplyJobMapper userApplyJobMapper;
    @Resource
    PartTimeJobMapper partTimeJobMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public UserBaseInfo getInfo(String userId) {
        return userJobMapper.getUserJobInfo(userId);
    }

    @Override
    public void updateById(UserBaseInfo userJobInfo) {
        userJobMapper.updateById(userJobInfo);
    }

    @Override
    public void insery(UserBaseInfo userJobInfo) {
        userJobMapper.insert(userJobInfo);
    }

    @Override
    public void apply(PartTimeJobVO jobCreaterVO) {
        String userId = UserUtils.getUserId();
        UserJob userJob = userApplyJobMapper.getJob(userId,String.valueOf(jobCreaterVO.getId()));
        if(userJob != null){
            return;
        }
        UserJob userJob1 = new UserJob();
        userJob1.setUserId(Long.valueOf(userId));
        userJob1.setJobId(jobCreaterVO.getId());
        userApplyJobMapper.insert(userJob1);
    }

    @Override
    public List<JobRecord> getRecord(int receiveState) throws NullPointerException{
        String userId = UserUtils.getUserId();
        List<JobRecord> jobRecord = userApplyJobMapper.getRecord(receiveState,userId);
        return jobRecord;
    }

    @Override
    public JobRecordUserVO getRecordUser(String id) throws NullPointerException{
        PartTimeJob partTimeJob = partTimeJobMapper.selectById(id);
        JobRecordUserVO jobRecordUserVO = new JobRecordUserVO();
        List<String> list = new ArrayList<>();
            list =  userMapper.getUserId(String.valueOf(partTimeJob.getId()));
            if(list.size()==0){
                BeanUtils.copyProperties(partTimeJob,jobRecordUserVO);
                return jobRecordUserVO;

            }

        List<User> userList = userApplyJobMapper.getJobRecordUser(list);

        BeanUtils.copyProperties(partTimeJob,jobRecordUserVO);
        if(userList == null){
            jobRecordUserVO.setUserList(new ArrayList<User>());
            return jobRecordUserVO;
        }
        jobRecordUserVO.setUserList(userList);
        return jobRecordUserVO;
    }

    @Override
    public void recordState(UserJob userJob) {
        UserJob userJob1 = userApplyJobMapper.getUserJob(userJob);
        userJob1.setReceiveState(userJob.getReceiveState());
        userApplyJobMapper.updateById(userJob1);
    }
}
