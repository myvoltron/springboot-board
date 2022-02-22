package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.BoardDTO;

import java.util.List;

public interface BoardService {

    public List<BoardDTO> getList();
    public BoardDTO getPost(Long id);
    public int insertBoard(BoardDTO boardDTO);
    public int updateBoard(BoardDTO boardDTO);
    public int deleteBoard(Long id);
}
