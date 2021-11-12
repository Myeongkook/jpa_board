package com.board.portfolio.repository;

import com.board.portfolio.domain.Member;
import com.board.portfolio.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryImplTest {
    
    @Autowired
    MemberService memberService;
    
    @Test
    @Rollback(value = false)
    @DisplayName("회원가입 테스트")
    public void signupTest(){
        Member member = new Member();
        member.setNickname("Mason");
        member.setPassword("1234");
        member.setEmail("myeongkook@vivans.net");
        Member signup = memberService.signup(member);
        assertThat(member.getNickname()).isEqualTo("Mason");
    }

}