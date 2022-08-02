package com.example.playground.serviceimpl;

import com.example.playground.Role;
import com.example.playground.pojo.Member;
import com.example.playground.pojo.MemberDto;
import com.example.playground.repository.MemberRepository;
import com.example.playground.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository userRepository) {
        this.memberRepository = userRepository;
    }

    @Override
    @Transactional
    public Long signUp(MemberDto memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member user = memberRepository.findMemberByUsername(username).get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println(user.getUsername() + " " + user.getPassword());

        if (username.equals("ROLE_ADMIN")) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
