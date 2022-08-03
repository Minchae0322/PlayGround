package com.example.playground.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String authority;
    private String email;
    private String phoneNum;
    private Sex sex;
    private Team team_id;
    private PlayGround playGround_id;



    public Member toEntity() {
        return Member.builder()
                .id(id)
                .username(username)
                .password(password)
                .authority(authority)
                .email(email)
                .phoneNum(phoneNum)
                .sex(sex)
                .team_id(team_id)
                .playGround_id(playGround_id)
                .build();
    }

    @Builder
    public MemberDto(Long id, String name, String password, String authority, String email, String phoneNum, Sex sex, Team team_id, PlayGround playGround_id) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.team_id = team_id;
        this.playGround_id = playGround_id;
    }
}
