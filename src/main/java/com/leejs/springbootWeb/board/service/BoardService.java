package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.BoardDTO;
import com.leejs.springbootWeb.board.domain.paging.PageMaker;

import java.util.List;

public interface BoardService {

    public List<BoardDTO> getList();
    public List<BoardDTO> getLimitedList(PageMaker pageMaker);
    public List<BoardDTO> getSearchList(PageMaker pageMaker, String searchType, String keyword);
    public BoardDTO getPost(Long id);
    public int insertBoard(BoardDTO boardDTO);
    public int updateBoard(BoardDTO boardDTO);
    public int deleteBoard(Long id);

    public int getCount();
    public int getCountByKeyword(String searchType, String keyword);
}
