package com.leejs.springbootWeb.board.repository;

import com.leejs.springbootWeb.board.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {

    List<MemberDTO> getMemberList();
    MemberDTO getMember(Long id);
    int insertMember(MemberDTO memberDTO);
    int updateMember(Long id, MemberDTO memberDTO);
    int deleteMember(Long id);
}
