package com.example.playground.pojo.playgroundpojo;

import com.example.playground.pojo.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("SOCCER")
@NoArgsConstructor
public class SoccerField extends Playground {
    private boolean isGrass;

    @Builder
    public SoccerField(Long Id, String name, String location, int maxPopulation, Reservation reservation, boolean isGrass) {
        super(Id, name, location, maxPopulation, reservation);
        this.isGrass = isGrass;
    }
}
