package com.leejs.springbootWeb.board.repository;

import com.leejs.springbootWeb.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    List<BoardDTO> getList();
    BoardDTO getPost(Long id);
    int insertBoard(BoardDTO boardDTO);
    int updateBoard(BoardDTO boardDTO);
    int deleteBoard(Long id);

    int getCount();
}
