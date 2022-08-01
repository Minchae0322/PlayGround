package com.example.playground.pojo;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "PlayGround_type")
public class PlayGroundType {
    @Id
    @NotNull
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(name = "PLAYGROUND_TYPENAME", unique = true)
    private String name;
    private String type;

    @Builder
    public PlayGroundType(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
