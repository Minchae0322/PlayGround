package com.example.playground.pojo;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @Nullable
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @Nullable
    @OneToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    @NotNull
    @OneToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    private PlayGround playGround;
    private String date;
    private String expiredDate;

    @Builder
    public Reservation(Long id, @Nullable Member member, @Nullable Team team, PlayGround playGround, String date, String expiredDate) {
        this.id = id;
        this.member = member;
        this.team = team;
        this.playGround = playGround;
        this.date = date;
        this.expiredDate = expiredDate;
    }
}
