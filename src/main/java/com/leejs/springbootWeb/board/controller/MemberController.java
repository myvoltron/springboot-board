package com.leejs.springbootWeb.board.controller;

import com.leejs.springbootWeb.board.domain.MemberDTO;
import com.leejs.springbootWeb.board.service.MemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberServiceImp memberServiceImp;

    @GetMapping("/list")
    public String memberList(Model model) {

        List<MemberDTO> memberList = memberServiceImp.getMemberList();
        model.addAttribute("memberList", memberList);

        return "memberIndex";
    }

    @GetMapping("/insert")
    public String memberInsertView() {

        return "memberInsert";
    }

    @PostMapping("/insert")
    public String memberInsert(HttpServletRequest request) {

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(request.getParameter("email"));
        memberDTO.setPassword(request.getParameter("password"));
        memberDTO.setName(request.getParameter("name"));

        memberServiceImp.insertMember(memberDTO);
        return "redirect:/member/list";
    }

    @GetMapping("/{id}")
    public String memberDetailView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("member", memberServiceImp.getMember(id));
        return "memberDetail";
    }

    @GetMapping("/update/{id}")
    public String memberUpdateView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("member", memberServiceImp.getMember(id));
        return "memberUpdate";
    }

    @PostMapping("/update")
    public String memberUpdate(HttpServletRequest request) {

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(Long.valueOf(request.getParameter("id")));
        memberDTO.setEmail(request.getParameter("email"));
        memberDTO.setPassword(request.getParameter("password"));
        memberDTO.setName(request.getParameter("name"));

        memberServiceImp.insertMember(memberDTO);
        return "redirect:/member/list";
    }

    @PostMapping("delete")
    public String memberDelete(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));

        memberServiceImp.deleteMember(id);
        return "redirect:/member/list";
    }
}
