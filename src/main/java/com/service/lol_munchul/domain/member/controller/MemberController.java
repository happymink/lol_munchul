package com.service.lol_munchul.domain.member.controller;

import com.service.lol_munchul.domain.member.request.SignUpRequest;
import com.service.lol_munchul.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/join")
    public Long join(
            @Valid @RequestBody SignUpRequest signUpRequest
            ){

        return 1L;
    }

    @PostMapping("/login")
    public Long login(){

        return 1L;
    }


    @PostMapping("/update")
    public Long update(){
        return 1L;
    }


}
