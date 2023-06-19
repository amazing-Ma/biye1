package com.example.demo.eneity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@TableName("user_job")
public class UserJob extends BaseEntity {
    /**
     * 用户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    /**
     * 兼职id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long jobId;
    /**
     * 录用状态
     */
    private int receiveState;
}
