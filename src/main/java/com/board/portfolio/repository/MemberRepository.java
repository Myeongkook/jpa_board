package com.board.portfolio.repository;

import com.board.portfolio.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long id);
    List<Member> AllMember();
}
