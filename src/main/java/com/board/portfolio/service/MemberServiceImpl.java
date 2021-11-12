package com.board.portfolio.service;

import com.board.portfolio.domain.Member;
import com.board.portfolio.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    @Override
    @Transactional
    public Member signup(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member login(Member member) {
        return null;
    }
}
