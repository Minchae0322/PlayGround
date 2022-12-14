package com.example.playground.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private List<Reservation> reservationList;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .username(username)
                .password(password)
                .authority(authority)
                .email(email)
                .phoneNum(phoneNum)
                .sex(sex)
                .team(team_id)
                .reservation(reservationList)
                .build();
    }

    @Builder
    public MemberDto(Long id, String username, String password, String authority, String email, String phoneNum, Sex sex, Team team_id, List<Reservation> reservationList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.phoneNum = phoneNum;
        this.sex = sex;
        this.team_id = team_id;
        this.reservationList = reservationList;
    }
}
