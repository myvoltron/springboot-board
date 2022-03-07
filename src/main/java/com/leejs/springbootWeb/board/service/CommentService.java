package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.CommentDTO;

import java.util.List;

public interface CommentService {

    public List<CommentDTO> getCommentList();
    public List<CommentDTO> getCommentListByPostId(Long post_id);
    public List<CommentDTO> getCommentListByWriterId(Long writer_id);
    public int insertComment(String content, Long post_id, Long writer_id);
}
