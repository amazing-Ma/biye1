package com.example.demo.eneity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.demo.utilsEneity.SnowflakeUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础类
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态
     */

    private int state;
    /**
     * 是否被删除
     */
    private int isDeleted;
}
