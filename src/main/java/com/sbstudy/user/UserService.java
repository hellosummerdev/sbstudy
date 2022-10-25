package com.sbstudy.user;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public int userCheck(UserLoginDto userLoginDto) {
//        select에서는 트라이 캐치가 거의 없음
        int isUser = userMapper.userCheck(userLoginDto);
        return isUser;
    }

    public boolean insertUser(UserLoginDto userLoginDto) { // 넘겨주는 걸 받는 Dto
//        Dummy Data
//        for (int i = 1; i <= 50; i++) {
//            UserLoginDto param = new UserLoginDto();
//            param.setUser_id("user" + i);
//            param.setUser_name("username" + i);
//            param.setUser_pwd("password" + i);
//            userMapper.insertUser(param);
//        }
//
//        return true;
        int isCreate = 0;
        try {
            isCreate = userMapper.insertUser(userLoginDto);
            System.out.println("[회원가입 성공]");
            return true;
        } catch (Exception e) {
            System.out.println("[회원가입 실패]");
            return false;
        }

//        if (isCreate == 1) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
