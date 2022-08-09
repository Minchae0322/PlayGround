package com.example.playground.pojo.playgroundpojo;

import com.example.playground.pojo.Reservation;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "playgroundType")
@Entity(name = "Playground")
public abstract class Playground {
    @Id
    @GeneratedValue
    @Column(name = "PLAYGROUND_ID")
    private Long id;
    @NotNull
    @Column(name = "PLAYGROUND_NAME", unique = true)
    private String name;
    @NotNull
    private String location;
    @NotNull
    private int maxPopulation;
    @OneToOne(mappedBy = "playGround")
    private Reservation reservation;


}
