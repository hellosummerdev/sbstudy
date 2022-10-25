package com.sbstudy.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/user")
public class UserController {

    // 자동주입
    @Autowired
    private UserService userService;

    // [View Controller]
    @GetMapping("/user/login")
    public String LoginView(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        System.out.println(session);
        session.removeAttribute("id");
        return "/user/login";
    }

    @PostMapping("/user/login")
    public String LoginPost(UserLoginDto userLoginDto, HttpSession session) {  // @ModelAttribute 자주쓰는거를 알아서 필요한걸 주입해준다.
         int isUser = userService.userCheck(userLoginDto);
//        System.out.println(userLoginDto); // lombok toString print
        if (isUser == 1) {
            session.setAttribute("id", userLoginDto.getUser_id());
            return "redirect:/board";
        } else {
            return "redirect:/user/login";
        }
    }

    @GetMapping("/user/join")
    public String LoginForm() {

        return "/user/join";
    }

    @PostMapping("/user/join")
    public String JoinForm(UserLoginDto userLoginDto) {
        boolean isCreate = userService.insertUser(userLoginDto);
        if (isCreate) {
            return "redirect:/user/login";
        } else{
            return "redirect:/user/join";

        }

    }

    // [Data Controller]
}
