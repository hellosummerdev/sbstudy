package com.sbstudy.board;

import lombok.Data;

@Data
public class BoardDto {

    private int seq;
    private int id;
    private String username;
    private String name;
    private String title;
    private String content;
    private String createDate;
    private String modifyDate;
}
