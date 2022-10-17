package com.sbstudy.user;

import org.apache.ibatis.annotations.Mapper;

//매핑 파일에 정의된 SQL을 호출하는 인터페이스
@Mapper
public interface UserDao {

    void insertUser(UserDto userDto);

    int selectUser(UserDto userDto);

    int selectUserLogin(UserDto userDto);

}
