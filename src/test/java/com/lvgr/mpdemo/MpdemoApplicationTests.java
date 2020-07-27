package com.lvgr.mpdemo;

import com.lvgr.mpdemo.entity.User;
import com.lvgr.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void save() {
        User u = new User();
        u.setAge(14);
        u.setEmail("dasd");
        //不set id mp有自己的主键生成策略
        //u.setId(Long.valueOf(1));
        u.setName("dsadddd");
        int insert = userMapper.insert(u);
        System.out.println(insert);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1287395746727931906L);
        user.setName("lilili");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void delete() {
        int i = userMapper.deleteById(1287395746727931906L);
        System.out.println(i);
    }




}
