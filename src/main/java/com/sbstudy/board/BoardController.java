package com.sbstudy.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
// 객체를 만들어 주는데, 단지 컨트롤러 역할을 하는 객체이다. 오직 하나만 생성된다(싱글톤).
public class BoardController {

    BoardController(){
        System.out.println("success");
    }

    // Return view
    // 데이터도 줄 수 있다
    // content-type : text/html
    @GetMapping("/board")
    public String boardVIEW(Model model){

        BoardDto boardDto = new BoardDto();
        boardDto.setNum(1);
        boardDto.setTitle("This is title");
        boardDto.setContent("This is content");
        boardDto.setWriter("Summer");

        model.addAttribute("board", boardDto);
        model.addAttribute("name", "Summer");
        model.addAttribute("test", "Test");
        return "board/board";
    }

}


