package com.example.playground.pojo;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Team")
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    @NotNull
    private String teamName;
    private String image;
    private Integer win;
    private Integer lose;

    @Builder
    public Team(Long id, String teamName, String image, Integer win, Integer lose) {
        this.id = id;
        this.teamName = teamName;
        this.image = image;
        this.win = win;
        this.lose = lose;
    }
}
