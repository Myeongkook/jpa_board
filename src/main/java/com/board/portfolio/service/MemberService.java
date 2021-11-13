package com.board.portfolio.service;

import com.board.portfolio.domain.Member;

public interface MemberService {
    Member signup(Member member);
    int login(Member member);
}
