package com.sbstudy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

//    public void insertUser(UserDto userDto) {
//        System.out.println(userDto);
//        userDao.insertUser(userDto);
//    }

    public boolean login(UserDto userDto) {

        int isExist = userDao.selectUserLogin(userDto);

        if (isExist == 1) {
            System.out.println("you already have an id");
        } else {
            return false;
        }
        return true;
    }

}
