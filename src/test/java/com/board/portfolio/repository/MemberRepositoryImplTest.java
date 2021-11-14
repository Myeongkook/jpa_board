package com.board.portfolio.repository;

import com.board.portfolio.domain.Member;
import com.board.portfolio.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryImplTest {
    
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    
    @Test
    @DisplayName("회원가입 테스트")
    public void signupTest(){
        Member member = new Member("myeongkook4@vivans.net", "1234", "tester");
        int signup = memberService.signup(member);
        assertThat(signup).isEqualTo(1);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("이메일로 아이디 찾기")
    public void findByEmail(){
        Member byEmail = memberRepository.findByEmail("myeongkook@vivans.net");
        assertThat(byEmail.getNickname()).isEqualTo("Mason");
    }

    @Test
    @Rollback(value = false)
    @DisplayName("회원번호로 아이디 찾기")
    public void findById(){
        Member byId = memberRepository.findById(1L);
        assertThat(byId.getNickname()).isEqualTo("Mason");
    }


    @Test
    @Rollback(value = false)
    @DisplayName("로그인 테스트")
    public void login(){
        int trueId = memberService.login(new Member("myeongkook@vivans.net", "1234", null));
        int falseId = memberService.login(new Member("myeongkook@vivans.net", "1235", null));
        int wrongId = memberService.login(new Member("myeongkook@vivans.ne", "1235", null));
        assertThat(trueId).isEqualTo(2);
        assertThat(falseId).isEqualTo(1);
        assertThat(wrongId).isEqualTo(0);
    }


}