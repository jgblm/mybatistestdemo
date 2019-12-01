import com.zxl.default_hikari_demo.HikariMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
// SpringBootTest需要指定具有@SpringBootConfiguration的入口类
@SpringBootTest(classes = HikariMain.class)
public class MysqlTest {

    @Autowired
    DataSource dataSource;

    // 在不使用第三方框架时,Springboot也会初始化
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 检查dataSource是否成功注入，并且可以获取connection
    @Test
    public void contextLoads(){
        System.out.println(dataSource.getClass());
        try(Connection connection=dataSource.getConnection()){
            System.out.println(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    // 检查jdbcTemplate是否成功注入，并执行相关操作
    @Test
    public void whenInitThenJdbcTemplateCanBeUsed(){
        System.out.println(jdbcTemplate);
        String sql="insert into name_table value(1001,'Jack')";
        int count=jdbcTemplate.update(sql);
        assertEquals(1,count);
    }

}
