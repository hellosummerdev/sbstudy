package com.sbstudy.user;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUser(UserLoginDto userLoginDto);

    int userCheck(UserLoginDto userLoginDto);

}
