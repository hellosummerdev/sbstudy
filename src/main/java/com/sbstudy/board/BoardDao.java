package com.sbstudy.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    int insertBoard(BoardDto boardDto);

    public List<BoardDto> boardList();
    
}


