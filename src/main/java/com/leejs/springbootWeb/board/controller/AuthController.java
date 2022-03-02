package com.leejs.springbootWeb.board.controller;

import com.leejs.springbootWeb.board.domain.MemberDTO;
import com.leejs.springbootWeb.board.service.MemberServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MemberServiceImp memberServiceImp;

    @GetMapping("/login")
    public String loginFormView() {

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println(email);
        System.out.println(password);

        HttpSession session = request.getSession();

        MemberDTO memberDTO = memberServiceImp.findByEmail(email);
        if(memberDTO != null) { // member가 존재한다면
            if(memberDTO.getPassword().equals(password)) { // 비밀번호 비교

                System.out.println("로그인 성공");
                session.setAttribute("member", memberDTO); // 비밀번호도 맞다면 session에 member 추가
            } else {

                System.out.println("비밀번호 틀림");
                System.out.println("이메일 혹은 비밀번호 확인해주세요"); // 비밀번호 틀림
            }
        } else {

            System.out.println("member 존재 X");
            System.out.println("이메일 혹은 비밀번호 확인해주세요"); // member가 존재하지 않음
        }

        return "redirect:/board/list";
    }
}
