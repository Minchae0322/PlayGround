package com.example.playground;

import com.example.playground.pojo.Member;
import com.example.playground.pojo.Team;
import com.example.playground.repository.MemberRepository;
import com.example.playground.repository.PlaygroundRepository;
import com.example.playground.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MemberTeamTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlaygroundRepository playGroundRepository;




    @Test
    @Transactional
    public void teamMemberTest() {
        Team team1 = Team.builder()
                .teamName("team2").build();
        Member member1 = Member.builder()
                .username("member2")
                .build();
        Member member2 = Member.builder()
                .username("member3")
                .build();
        teamRepository.save(team1);
        member1.setTeam(team1);
        member2.setTeam(team1);

        memberRepository.save(member1);
        memberRepository.save(member2);


        //entityManager.flush();
        Optional<Member> member3 = memberRepository.findMemberByUsername("member3");
        Member member4 = member3.get();
        assertEquals("team2", member4.getTeam().getTeamName());

    }


    static class TeamService {

    }
}
