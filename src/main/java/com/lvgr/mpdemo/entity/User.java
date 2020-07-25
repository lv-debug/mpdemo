package com.lvgr.mpdemo.entity;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import lombok.Data;

/**
 * @author lvgr
 * @date 2020/7/21 22:39
 * @desc
 */
@Data
public class User extends Wrapper<User> {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Override
    public User getEntity() {
        return null;
    }

    @Override
    public MergeSegments getExpression() {
        return null;
    }

    @Override
    public String getSqlSegment() {
        return null;
    }
}
