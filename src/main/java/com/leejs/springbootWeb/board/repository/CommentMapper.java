package com.leejs.springbootWeb.board.repository;

import com.leejs.springbootWeb.board.domain.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    List<CommentDTO> getCommentList();
    List<CommentDTO> getCommentListByPostId(Long post_id);
    List<CommentDTO> getCommentListByWriterId(Long writer_id);
    int insertComment(String content, Long post_id, Long writer_id);
}
