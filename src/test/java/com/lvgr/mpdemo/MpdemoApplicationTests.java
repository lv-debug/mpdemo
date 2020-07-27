package com.lvgr.mpdemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lvgr.mpdemo.entity.User;
import com.lvgr.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

        //批量id查询
        List<User> users1 = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users1);

        //根据map条件查询
        Map<String,Object> map = new HashMap<>();
        //map.put("name","lilili");
        map.put("age","14");
        List<User> users2 = userMapper.selectByMap(map);
        System.out.println(users2);
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
        user.setId(1287751685733720065L);
        user.setName("lilili");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void delete() {
        int i = userMapper.deleteById(1287395746727931906L);
        System.out.println(i);
    }

    /**
     * 乐观锁
     */
    @Test
    public void lgs() {
        User user = userMapper.selectById(1287751685733720065L);
        user.setName("lvgr");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void testPage() {
        //先要配置插件
        //param1:当前页。param2:
        Page<User> page = new Page<>(1,3);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        //当前页
        System.out.println(page.getCurrent());
        //显示数据的记录
        System.out.println(page.getRecords());
        //每页显示数据
        System.out.println(page.getSize());
        //共计几条数据
        System.out.println(page.getTotal());
        //总页数
        System.out.println(page.getPages());
        //是否有下一页
        System.out.println(page.hasNext());
        //是否有上一页
        System.out.println(page.hasPrevious());
        System.out.println(userIPage);
    }





}
