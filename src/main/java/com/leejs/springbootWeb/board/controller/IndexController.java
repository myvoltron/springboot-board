package com.leejs.springbootWeb.board.controller;

import com.leejs.springbootWeb.board.domain.BoardDTO;
import com.leejs.springbootWeb.board.service.BoardServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class IndexController {

    @Autowired
    private BoardServiceImp boardServiceImp;

    @GetMapping("/")
    public String homeView(Model model) {
        List<BoardDTO> postList = boardServiceImp.getList();

        model.addAttribute("postList", postList);

        return "index";
    }

    @GetMapping("/list")
    public String indexView(Model model) {

        int listCount = boardServiceImp.getCount();
        List<BoardDTO> postList = boardServiceImp.getList();

        model.addAttribute("count", listCount);
        model.addAttribute("postList", postList);

        return "index";
    }

    @GetMapping("/insert")
    public String insertView() {

        return "insert";
    }

    @PostMapping("/insert")
    public String insertBoard(HttpServletRequest request) {

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(request.getParameter("title"));
        boardDTO.setContent(request.getParameter("content"));

        boardServiceImp.insertBoard(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}")
    public String detailView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("post", boardServiceImp.getPost(id));

        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("post", boardServiceImp.getPost(id));

        return "update";
    }

    @PostMapping("/update")
    public String updateBoard(HttpServletRequest request) {

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(Long.parseLong(request.getParameter("id")));
        boardDTO.setTitle(request.getParameter("title"));
        boardDTO.setContent(request.getParameter("content"));

        boardServiceImp.updateBoard(boardDTO);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String deleteBoard(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));

        boardServiceImp.deleteBoard(id);
        return "redirect:/board/list";
    }
}
