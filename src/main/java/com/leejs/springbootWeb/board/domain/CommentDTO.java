package com.leejs.springbootWeb.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private Long id;
    private Long writer_id;
    private Long post_id;
    private String content;
}
