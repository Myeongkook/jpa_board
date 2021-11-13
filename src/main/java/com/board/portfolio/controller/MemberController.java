package com.board.portfolio.controller;

import com.board.portfolio.domain.Member;
import com.board.portfolio.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String signupMember(){
        return "signup";
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Member member){
        if (memberService.login(member) == 2){
            return "redirect:/";
        }else{
            return "login";
        }
    }
}
