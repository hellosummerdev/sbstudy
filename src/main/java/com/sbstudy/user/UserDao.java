package com.sbstudy.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    void insertUser(UserDto userDto);

    int selectUser(UserDto userDto);

    int selectUserLogin(UserDto userDto);

}
