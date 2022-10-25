package com.sbstudy.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController Spring에서 API 개발 시 사용. 이 안에 @Controller @ResponseBody가 들어있음
public class BoardController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private BoardService boardService;

    @GetMapping("/board") // <- 로그인 안돼있으면 로그인 해라 하기, 로그인 되어있는지 확인 어떻게해?
     public String board() {
        return "board/board";
    }

    @PostMapping("/board/list")
    @ResponseBody
    public Map<String, Object> boardList() {
        System.out.println("BoardController.boardList");
        Map<String, Object> map = new HashMap<>();
        try {
            List<BoardDto> boardList = boardService.selectBoard(); // [ ]
            map.put("data", boardList);
            map.put("status", 200);
        } catch (Exception e) {
            map.put("status", 500);
        }

//      test
//        String book = "자바의 정석";
//        int[] intArr = new int[]{1,2,3,4};
//        Map<String, Object> bookMap = new HashMap<>();
//        bookMap.put("book", book);
//        bookMap.put("intArr", intArr);

        return map;
    }
}
