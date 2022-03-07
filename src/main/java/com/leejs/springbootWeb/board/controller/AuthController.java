package com.leejs.springbootWeb.board.controller;

import com.leejs.springbootWeb.board.domain.LoginInfo;
import com.leejs.springbootWeb.board.domain.MemberDTO;
import com.leejs.springbootWeb.board.service.LoginService;
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
    private LoginService loginService;

    @GetMapping("/login")
    public String loginFormView() {

        return "login";
    }

    @PostMapping("/login")
    public String login(LoginInfo loginInfo, HttpServletRequest request) {

        MemberDTO memberDTO = loginService.login(loginInfo.getEmail(), loginInfo.getPassword());
        if(memberDTO == null) {
            return "redirect:/auth/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("member", memberDTO);

        return "redirect:/board/list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/board/list";
    }
}
