package com.example.playground.service;

import com.example.playground.pojo.MemberDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface MemberService {
    @Transactional
    Long signUp(MemberDto memberDto);
    Optional<MemberDto> login(MemberDto memberDto);
}
