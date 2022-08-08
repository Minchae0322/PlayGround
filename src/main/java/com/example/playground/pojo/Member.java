package com.example.playground.pojo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Member")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
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
    @Nullable
    @OneToMany(mappedBy = "member")
    private List<Reservation> reservation = new ArrayList<>();


    @Builder
    public Member(Long id, String username, String password, String authority, String email, String phoneNum, Sex sex, @Nullable Team team, @Nullable PlayGround playGround_id, @Nullable List<Reservation> reservation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.team = team;
        this.playGround_id = playGround_id;
        this.reservation = reservation;
    }
}
