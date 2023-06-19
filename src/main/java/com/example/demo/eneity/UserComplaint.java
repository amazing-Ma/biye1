package com.example.demo.eneity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_complaint")
public class UserComplaint extends  BaseEntity{
    private Long userId;

    private Long jobId;

    private String email;

    private String  complaintTitle;

    private String complaintType;

    private String isSend;
}
