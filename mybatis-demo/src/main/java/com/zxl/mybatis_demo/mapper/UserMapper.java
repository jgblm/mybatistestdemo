package com.zxl.mybatis_demo.mapper;

import com.zxl.mybatis_demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUser();
    User selectUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
