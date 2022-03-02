package com.leejs.springbootWeb.board.service;

import com.leejs.springbootWeb.board.domain.MemberDTO;
import com.leejs.springbootWeb.board.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImp implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<MemberDTO> getMemberList() {
        return memberMapper.getMemberList();
    }

    @Override
    public MemberDTO getMember(Long id) {
        return memberMapper.getMember(id);
    }

    @Override
    public MemberDTO findByEmail(String email) {
        return memberMapper.getMemberByEmail(email);
    }

    @Override
    public int insertMember(MemberDTO memberDTO) {
        return memberMapper.insertMember(memberDTO);
    }

    @Override
    public int updateMember(Long id, MemberDTO memberDTO) {
        return memberMapper.updateMember(id, memberDTO);
    }

    @Override
    public int deleteMember(Long id) {
        return memberMapper.deleteMember(id);
    }
}
