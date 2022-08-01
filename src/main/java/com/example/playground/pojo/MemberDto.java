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
    private String name;
    private String password;
    private String authority;
    private String email;
    private String phoneNum;
    private Sex sex;

    public Member toEntity() {
        return Member.builder().
                id(id)
                .name(name)
                .password(password)
                .authority(authority)
                .email(email)
                .phoneNum(phoneNum)
                .sex(sex)
                .build();
    }

    @Builder
    public MemberDto(Long id, String name, String password, String authority, String email, String phoneNum, Sex sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.email = email;
        this.phoneNum = phoneNum;
        this.sex = sex;
    }
}
