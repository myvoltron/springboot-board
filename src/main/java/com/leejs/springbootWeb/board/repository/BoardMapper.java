package com.leejs.springbootWeb.board.repository;

import com.leejs.springbootWeb.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    List<BoardDTO> getList();
    List<BoardDTO> getLimitedList(int offset, int perPageNum);
    List<BoardDTO> getSearchList(int offset, int perPageNum, String searchType, String keyword);
    BoardDTO getPost(Long id);
    int insertBoard(BoardDTO boardDTO);
    int updateBoard(BoardDTO boardDTO);
    int deleteBoard(Long id);

    int getCount();
    int getCountByKeyword(String searchType, String keyword);
}
