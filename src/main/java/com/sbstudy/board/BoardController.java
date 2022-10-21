package com.sbstudy.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
// 객체를 만들어 주는데, 단지 컨트롤러 역할을 하는 객체이다. 오직 하나만 생성된다(싱글톤).
public class BoardController {


    BoardController(){
        System.out.println("success");
    }

    // Return view
    // 데이터도 줄 수 있다
    // content-type : text/html

    @GetMapping("/board/board") //url주소
    public String boardWrite(Model model){  // form for new board
//        BoardDto boardDto = new BoardDto();
//        boardDto.setSeq(1);
//        boardDto.setTitle("This is title");
//        boardDto.setContent("This is content");
//        boardDto.setName("Summer");

//        model.addAttribute("board", boardDto);
//        model.addAttribute("name", "Summer");
//        model.addAttribute("test", "Test");
        return "board/board";
    }

    @Autowired
    private BoardService boardService;
    @PostMapping("/board/create")
    public String insertBoard(BoardDto boardDto){
        boolean isInsert = boardService.insertBoard(boardDto);

        if (isInsert) {
            System.out.println("게시판 글 추가 성공");
        } else {
            System.out.println("게시판 글 추가 실패");
        }
        return "board/boardList";
    }

    @GetMapping("/board/boardList")
    public String boardVIEW(Model model) {
        // BoardDto boardDto = new BoardDto();

        List<BoardDto> boardList = boardService.sellectAllBoard();
        model.addAttribute("list", boardList);

        return "board/boardList";
    }

}


