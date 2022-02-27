package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.MemberDTO;

import java.util.List;

public interface MemberService {

    public List<MemberDTO> getMemberList();
    MemberDTO getMember(Long id);
    int insertMember(MemberDTO memberDTO);
    int updateMember(Long id, MemberDTO memberDTO);
    int deleteMember(Long id);
}
