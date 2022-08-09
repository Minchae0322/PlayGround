package com.example.playground;

import com.example.playground.pojo.playgroundpojo.Playground;
import com.example.playground.pojo.playgroundpojo.SoccerField;
import com.example.playground.repository.PlaygroundRepository;
import com.example.playground.service.PlaygroundService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlaygroundTest {

    @Autowired
    PlaygroundRepository playGroundRepository;
    @Autowired
    PlaygroundService playgroundService;

    @Test
    @Transactional
    void registerPlaygroundTest() {
        Playground playground1 = SoccerField.builder()
                .name("관악구축구장1")
                .maxPopulation(16)
                .location("관악구")
                .isGrass(true)
                .build();
        playgroundService.register(playground1);

        assertEquals(playground1.getName(), playGroundRepository.findPlaygroundByName("관악구축구장1").get().getName());
    }

    @Test
    @Transactional
    void deletePlaygroundTest() {
        Playground playground1 = SoccerField.builder()
                .name("관악구축구장1")
                .maxPopulation(16)
                .location("관악구")
                .isGrass(true)
                .build();
        playgroundService.register(playground1);
        playgroundService.delete(playground1);

        assertEquals(null, playGroundRepository.findPlaygroundByName("관악구축구장1").get().getName());
    }



}
