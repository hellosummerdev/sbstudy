package com.sbstudy.board;

import lombok.Data;

@Data
public class BoardDto {
    private int num;
    private String title;
    private String content;
    private String writer;
}
