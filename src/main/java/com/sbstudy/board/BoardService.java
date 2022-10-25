package com.sbstudy.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public void insertBoard(BoardDto boardDto) {
        boardMapper.insertBoard(boardDto);
    }

    public List<BoardDto> selectBoard() {
//        Dummy Data
//        for (int i = 1; i <= 100; i++) {
//            BoardDto param = new BoardDto();
//            param.setBoard_title("title"+i);
//            param.setBoard_content("content"+i);
//            param.setUser_id("test");
//            boardMapper.insertBoard(param);
//        }

        List<BoardDto> boardList= boardMapper.selectBoard();
        return boardList;
    }
}
