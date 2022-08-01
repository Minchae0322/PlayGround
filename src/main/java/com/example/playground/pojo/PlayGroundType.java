package com.example.playground.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "PlayGround_type")
public class PlayGroundType {
    @Id
    @GeneratedValue
    @Column(name = "PLAYGROUND_NAME2")
    private String name;
    private String type;

    @Builder
    public PlayGroundType(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
