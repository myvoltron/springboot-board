package com.leejs.springbootWeb.board.controller;

import com.leejs.springbootWeb.board.domain.BoardDTO;
import com.leejs.springbootWeb.board.domain.CommentDTO;
import com.leejs.springbootWeb.board.domain.MemberDTO;
import com.leejs.springbootWeb.board.domain.paging.PageMaker;
import com.leejs.springbootWeb.board.service.BoardServiceImp;
import com.leejs.springbootWeb.board.service.CommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardServiceImp boardServiceImp;

    @Autowired
    private CommentServiceImp commentServiceImp;

    @GetMapping("/")
    public String homeToIndex() {

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String indexView(HttpServletRequest request, Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "searchType", defaultValue = "title") String searchType,
                            @RequestParam(value = "keyword", defaultValue = "") String keyword) {

        // getSession(true) 를 사용하면 처음 들어온 사용자도 세션이 만들어지기 때문에 false로 받음
//        HttpSession session = request.getSession(false);
//        if(session != null) {
//            MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
//
//            if(memberDTO != null) {
//                model.addAttribute("member", memberDTO);
//            }
//        }

        int totalCount = boardServiceImp.getCount();
        PageMaker pageMaker = new PageMaker();
        pageMaker.setPage(page);
        pageMaker.setTotalCount(totalCount);

        if(searchType.equals("title"))
            searchType = "T";
        else if(searchType.equals("content"))
            searchType = "C";
        else
            searchType = "T";

        // List<BoardDTO> postList = boardServiceImp.getLimitedList(pageMaker);
        List<BoardDTO> postList = boardServiceImp.getSearchList(pageMaker, searchType, keyword);

        model.addAttribute("postList", postList);
        model.addAttribute("pageMaker", pageMaker);

        return "index";
    }

    @GetMapping("/insert")
    public String insertView() {

        return "insert";
    }

//    @PostMapping("/insert")
//    public String insertBoard(HttpServletRequest request) {
//
//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setTitle(request.getParameter("title"));
//        boardDTO.setContent(request.getParameter("content"));
//
//        boardServiceImp.insertBoard(boardDTO);
//        return "redirect:/board/list";
//    }

    /*
    HttpServletRequest로 매개변수를 받아서 request의 getParameter() 메서드로 post값들을 받는 방법도 있지만
    그냥 POST의 key(name)으로 객체를 만들어서 받을 수도 있다.
     */
    @PostMapping("/insert")
    public String insertBoard(BoardDTO boardDTO) {

        boardServiceImp.insertBoard(boardDTO);
        return "redirect:/board/list";
    }

    // 상세보기 : 글과 댓글목록을 가져와야 함
    @GetMapping("/{id}")
    public String detailView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("post", boardServiceImp.getPost(id));
        model.addAttribute("comments", commentServiceImp.getCommentListByPostId(id));

        return "detail";
    }

    @PostMapping("/comment/{post_id}")
    public String insertComment(@PathVariable("post_id") Long post_id, CommentDTO commentDTO) {

        commentServiceImp.insertComment(commentDTO.getContent(), post_id, null);
        return "redirect:/board/" + post_id;
    }

    @GetMapping("/update/{id}")
    public String updateView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("post", boardServiceImp.getPost(id));

        return "update";
    }

    @PostMapping("/update")
    public String updateBoard(BoardDTO boardDTO) {

        boardServiceImp.updateBoard(boardDTO);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String deleteBoard(Long id) {

        boardServiceImp.deleteBoard(id);
        return "redirect:/board/list";
    }
}
