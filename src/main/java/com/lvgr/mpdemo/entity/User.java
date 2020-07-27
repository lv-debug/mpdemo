package com.lvgr.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import lombok.Data;

import java.util.Date;

/**
 * @author lvgr
 * @date 2020/7/21 22:39
 * @desc
 */
@Data
public class User{

    /**
     * AUTO 表示自动增长 UUID 随机唯一值 ID_WORKER mp自带，生成19位值（数字） ID_WORKER_STRmp自带，生成19位值（字符串）
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 乐观锁
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    /**
     * 表中create_time 实体类使用驼峰
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
