package com.example.playground;

import com.example.playground.pojo.Member;
import com.example.playground.pojo.PlayGround;
import com.example.playground.pojo.PlayGroundType;
import com.example.playground.pojo.Team;
import com.example.playground.repository.MemberRepository;
import com.example.playground.repository.PlayGroundRepository;
import com.example.playground.repository.PlayGroundTypeRepository;
import com.example.playground.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MemberTeamTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayGroundRepository playGroundRepository;


    @Autowired
    PlayGroundTypeRepository playGroundTypeRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void playGroundTypeTest() {
        PlayGroundType playGroundType1 = PlayGroundType.builder()
                .name("캠퍼스4농구장")
                .type("농구장").build();
        //entityManager.persist(playGroundType1);
        playGroundTypeRepository.save(playGroundType1);
        entityManager.flush();


        PlayGround playGround1 = PlayGround.builder()
                .name("캠퍼스4농구장").build();
        playGround1.setPlayGroundTypeName(playGroundTypeRepository.findPlayGroundTypeByName("캠퍼스4농구장").get());

        assertEquals("농구장", playGround1.getPlayGroundTypeName().getType());

    }

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
        member1.setTeam_id(team1);
        member2.setTeam_id(team1);

        memberRepository.save(member1);
        memberRepository.save(member2);


        //entityManager.flush();
        Optional<Member> member3 = memberRepository.findMemberByUsername("member3");
        Member member4 = member3.get();
        assertEquals("team2", member4.getTeam_id().getTeamName());

    }

    @Test
    @Transactional
    public void playGroundTest() {
        Team team1 = Team.builder()
                .teamName("team3").build();
        Member member1 = Member.builder()
                .username("member4")
                .build();
        Member member2 = Member.builder()
                .username("member5")
                .build();
        PlayGround playGround1 = PlayGround.builder()
                .name("play1")
                .build();
        playGroundRepository.save(playGround1);
        teamRepository.save(team1);
        member1.setTeam_id(team1);
        member2.setTeam_id(team1);
        member1.setPlayGround_id(playGround1);
        member2.setPlayGround_id(playGround1);
        memberRepository.save(member1);
        memberRepository.save(member2);


        entityManager.flush();
        Optional<Member> member3 = memberRepository.findMemberByUsername("member4");
        Member member4 = member3.get();
        assertEquals("team3", member4.getTeam_id().getTeamName());
        assertEquals("play1", member4.getPlayGround_id().getName());

    }

    static class TeamService {

    }
}
