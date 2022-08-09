package com.example.playground.pojo;


import com.example.playground.pojo.playgroundpojo.Playground;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @Nullable
    @OneToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    @NotNull
    @OneToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    private Playground playGround;
    @NotNull
    private String side;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiredDate;

    @Builder
    public Reservation(Long id, @Nullable Member member, @Nullable Team team, Playground playGround, String side, Date date, Date expiredDate) {
        this.id = id;
        this.member = member;
        this.team = team;
        this.playGround = playGround;
        this.side = side;
        this.date = date;
        this.expiredDate = expiredDate;
    }
}
