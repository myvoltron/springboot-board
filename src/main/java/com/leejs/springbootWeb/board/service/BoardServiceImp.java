package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.paging.PageMaker;
import com.leejs.springbootWeb.board.repository.BoardMapper;
import com.leejs.springbootWeb.board.domain.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImp implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {

        return boardMapper.getList();
    }

    @Override
    public List<BoardDTO> getLimitedList(PageMaker pageMaker) {

        return boardMapper.getLimitedList(pageMaker.getPageStart(), pageMaker.getPerPageNum());
    }

    @Override
    public List<BoardDTO> getSearchList(PageMaker pageMaker, String searchType, String keyword) {

        return boardMapper.getSearchList(pageMaker.getPageStart(), pageMaker.getPerPageNum(), searchType, keyword);
    }

    @Override
    public BoardDTO getPost(Long id) {

        return boardMapper.getPost(id);
    }

    @Override
    public int insertBoard(BoardDTO boardDTO) {

        return boardMapper.insertBoard(boardDTO);
    }

    @Override
    public int updateBoard(BoardDTO boardDTO) {

        return boardMapper.updateBoard(boardDTO);
    }

    @Override
    public int deleteBoard(Long id) {

        return boardMapper.deleteBoard(id);
    }

    @Override
    public int getCount() {

        return boardMapper.getCount();
    }

    @Override
    public int getCountByKeyword(String searchType, String keyword) {
        return boardMapper.getCountByKeyword(searchType, keyword);
    }

}
