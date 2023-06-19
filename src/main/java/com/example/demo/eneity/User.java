package com.example.demo.eneity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * @2023.3.16
 */
@Data
@TableName(value = "user")
public class User extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     *用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userNumber;
    /**
     * 用户手机号
     */
    private String userPasswd;
    /**
     * 用户头像
     */
    private String userPic;
    /**
     * 用户等级
     * 0：管理员
     * 1：服务专员
     * 2：普通用户
     */
    private int userLevel;
    /**
     * 用户信誉分
     */
    private int userScore;
    /**
     * 封禁起始时间
     */
    private Date userInterStartTime;
    /**
     * 封禁天数
     */
    private int userInterDate;
    /**
     * 是否锁定
     */
    private String lockFlag;




}
