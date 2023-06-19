package com.example.demo.VO;

import com.example.demo.eneity.UserBaseInfo;
import com.example.demo.eneity.UserEduInfo;
import com.example.demo.eneity.UserJobInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserBaseInfoVO extends UserBaseInfo {

    private List<UserEduInfo> userEduInfos = new ArrayList<>();

    private List<UserJobInfo> userJobInfos = new ArrayList<>();


}
