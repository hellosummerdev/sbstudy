package com.sbstudy.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    public boolean insertBoard(BoardDto boardDto) {
        int isInsert = boardDao.insertBoard(boardDto);

        if (isInsert == 1) {
            return true;
        } else {
            return false;
        }
    }
}
