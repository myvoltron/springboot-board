package com.leejs.springbootWeb.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private Long id;
    private String email;
    private String password;
    private String name;
}
