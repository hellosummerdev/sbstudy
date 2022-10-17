package com.sbstudy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/user/login")
    public String loginPost(UserDto userDto, Model model) {
        System.out.println(userDto);
//        userService.insertUser(userDto);

        boolean isExist = userService.login(userDto);
        if (isExist) {
            return "board/boardList";
        } else {
            // 화면에 표시해주는 애
            model.addAttribute("message", "id or password is wrong");
            return "user/login";
        }

    }


}
