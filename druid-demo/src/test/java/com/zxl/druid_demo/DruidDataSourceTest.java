package com.zxl.druid_demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.zxl.druid_demo.config.DruidConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DruidDemoMain.class)
public class DruidDataSourceTest {

    @Resource
    DataSource dataSource;

    @Value("${spring.datasource.maxActive}")
    int maxActive;
    @Value("${spring.datasource.initialSize}")
    int initialSize;

    @Test
    public void contextLoads(){
        System.out.println(dataSource.getClass());
        try(Connection connection=dataSource.getConnection()){
            System.out.println(connection);
            DruidDataSource druidDataSource=(DruidDataSource)dataSource;
            System.out.println("maxActive :"+maxActive);
            System.out.println("initialSize :"+initialSize);
            assertEquals(maxActive,druidDataSource.getMaxActive());
            assertEquals(initialSize,druidDataSource.getInitialSize());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
