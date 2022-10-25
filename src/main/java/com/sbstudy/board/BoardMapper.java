package com.sbstudy.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertBoard(BoardDto boardDto);

    List<BoardDto> selectBoard();
}
