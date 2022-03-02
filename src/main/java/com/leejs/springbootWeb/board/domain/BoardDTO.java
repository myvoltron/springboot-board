package com.leejs.springbootWeb.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private Long writer_id;
    private Long views;
}
