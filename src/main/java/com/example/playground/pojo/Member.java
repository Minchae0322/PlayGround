package com.example.playground.pojo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    private String authority;
    private String email;
    private String phoneNum;
    private Sex sex;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team_id;
    @ManyToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    private PlayGround playGround_id;

    @Builder
    public Member(Long id, String name, String password, String authority, String email, String phoneNum, Sex sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.phoneNum = phoneNum;
        this.sex = sex;
    }
    

}
