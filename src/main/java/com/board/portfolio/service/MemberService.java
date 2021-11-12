package com.board.portfolio.service;

import com.board.portfolio.domain.Member;

public interface MemberService {
    Member signup(Member member);
    Member login(Member member);
}
