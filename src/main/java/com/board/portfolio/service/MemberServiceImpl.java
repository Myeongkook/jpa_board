package com.board.portfolio.service;

import com.board.portfolio.domain.Member;
import com.board.portfolio.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;


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
    public int login(Member member) {
        try{
            Member findByEmail = memberRepository.findByEmail(member.getEmail());
            if (findByEmail.getPassword().equals(member.getPassword())) {
                return 2;
            } else if (!findByEmail.getPassword().equals(member.getPassword())) {
                return 1;
            }
        }catch(EmptyResultDataAccessException e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return 0;
        }
        return 0;
    }
}
