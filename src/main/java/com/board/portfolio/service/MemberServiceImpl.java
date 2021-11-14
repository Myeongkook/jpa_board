package com.board.portfolio.service;

import com.board.portfolio.domain.Member;
import com.board.portfolio.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;



@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    @Override
    @Transactional
    public int signup(Member member) {
        Member findByEmail = memberRepository.findByEmail(member.getEmail());
        if(findByEmail == null){
            memberRepository.save(member);
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int login(Member member) {
        try{
            if (!member.getEmail().equals("")&&!member.getPassword().equals("")) {
                Member findByEmail = memberRepository.findByEmail(member.getEmail());
                if (findByEmail.getPassword().equals(member.getPassword())) {
                    return 2;
                } else if (!findByEmail.getPassword().equals(member.getPassword())) {
                    return 1;
                }
            }
        }catch(EmptyResultDataAccessException e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return 0;
        }
        return 0;
    }
}
