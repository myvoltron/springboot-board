package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.CommentDTO;
import com.leejs.springbootWeb.board.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDTO> getCommentList() {
        return commentMapper.getCommentList();
    }

    @Override
    public List<CommentDTO> getCommentListByPostId(Long post_id) {
        return commentMapper.getCommentListByPostId(post_id);
    }

    @Override
    public List<CommentDTO> getCommentListByWriterId(Long writer_id) {
        return commentMapper.getCommentListByWriterId(writer_id);
    }

    @Override
    public int insertComment(String content, Long post_id, Long writer_id) {
        return commentMapper.insertComment(content, post_id, writer_id);
    }
}
