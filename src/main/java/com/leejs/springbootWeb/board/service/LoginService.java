package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.MemberDTO;
import com.leejs.springbootWeb.board.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private MemberServiceImp memberServiceImp;

    // 로그인에 성공하면 MemberDTO 객체를 반환하고 실패했으면 null을 반환한다.
    public MemberDTO login(String email, String password) {

        MemberDTO memberDTO = memberServiceImp.findByEmail(email);

        if(memberDTO != null) { // member가 존재한다면
            if(memberDTO.getPassword().equals(password)) { // 비밀번호 비교

                System.out.println("로그인 성공");
                return memberDTO;
            } else {

                System.out.println("비밀번호 틀림");
                System.out.println("이메일 혹은 비밀번호 확인해주세요"); // 비밀번호 틀림

                return null;
            }
        } else {

            System.out.println("member 존재 X");
            System.out.println("이메일 혹은 비밀번호 확인해주세요"); // member가 존재하지 않음

            return null;
        }
    }
}
