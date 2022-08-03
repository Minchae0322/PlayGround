package com.example.playground.pojo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String authority;
    private String email;
    private String phoneNum;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    @ManyToOne
    @Nullable
    @JoinColumn(name = "PLAYGROUND_ID")
    private PlayGround playGround_id;

    @Builder
    public Member(Long id, String username, String password, String authority, String email, String phoneNum, Sex sex, Team team, PlayGround playGround_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.team = team;
        this.playGround_id = playGround_id;
    }
}
