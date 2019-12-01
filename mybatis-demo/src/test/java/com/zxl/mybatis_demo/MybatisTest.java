package com.zxl.mybatis_demo;

import com.zxl.mybatis_demo.domain.User;
import com.zxl.mybatis_demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    // 查看数据源信息
    @Test
    public void contextLoads() {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        try(Connection connection = dataSource.getConnection()){
            System.out.println("连接>>>>>>>>>" + connection);
            System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // springboot初始化后，userMapper是否可以使用
    @Test
    public void whenInitIfUserMapperCanBeUsed(){
        User user=new User();
        user.setId(1004);
        user.setName("green");
        userMapper.addUser(user);
        List<User> list=userMapper.selectUser();
        assertTrue(list.size()>=1);
    }

}
