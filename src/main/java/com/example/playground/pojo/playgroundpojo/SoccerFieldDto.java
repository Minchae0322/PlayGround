package com.example.playground.pojo.playgroundpojo;

import com.example.playground.pojo.Reservation;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Getter
@Setter
public class SoccerFieldDto {
    private  Long id;
    private String name;
    private  String location;
    private  int maxPopulation;
    private  Reservation reservation;
    private  boolean isGrass;

    public SoccerField toEntity() {
        return SoccerField.builder()
                .Id(id)
                .name(name)
                .location(location)
                .maxPopulation(maxPopulation)
                .reservation(reservation)
                .isGrass(isGrass)
                .build();
    }

    @Builder
    public SoccerFieldDto(Long id, String name, String location, int maxPopulation, Reservation reservation, boolean isGrass) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.maxPopulation = maxPopulation;
        this.reservation = reservation;
        this.isGrass = isGrass;
    }
}
