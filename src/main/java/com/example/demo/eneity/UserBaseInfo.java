package com.example.demo.eneity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("user_base_info")
public class UserBaseInfo extends BaseEntity{
    /**
     * 用户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    /**
     * 真实头像
     */
    private String truePic;
    /**
     * 真实姓名
     */
    private String trueName;
    /**
     *用户性别
     */
    private String sexyType;
    /**
     *所在城市
     */
    private String baseCity;
    /**
     * 出生年月
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
    /**
     * 身高
     */
    private String tall;
    /**
     * 教育状态
     */
    private String eduState;
    /**
     * 最高学历
     */
    private String highEdu;
    /**
     * 手机号
     */
    private String phone;
    /**
     * QQ
     */
    private String QQ;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 微信
     */
    private String weChat;
    /**
     * 自我评价
     */
    private String selfIntroduce;
    /**
     * 附件简历
     */
    private String annex;



}
