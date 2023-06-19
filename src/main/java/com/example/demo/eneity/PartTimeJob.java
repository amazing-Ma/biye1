package com.example.demo.eneity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 兼职类
 */
@Data
@TableName("part_time_job")
public class PartTimeJob extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 兼职名称
     */
    private String title;
    /**
     * 兼职类型
     */
    private String jobType;
    /**
     * 工作开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;
    /**
     * 工作结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;
    /**
     * 性别要求
     *
     * 0不限
     * 1男
     * 2 女
     */
    private String genderType;

    /**
     * 兼职费用
     */
    private String jobCount;
    /**
     * 工作地点
     */
    private String workSpace;
    /**
     * 职位详情
     */
    private String jobDetail;
    /**
     * 招聘人数
     */
    private int jobNumber;
    /**
     * 招聘发起者
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long jobCreater;
    /**
     * 当前进度
     * 0正在审核
     * 1审核成功
     * 2审核失败
     */
    private int currentProgress;



}
