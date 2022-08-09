package com.example.playground.service;

import com.example.playground.pojo.playground.Playground;
import org.springframework.transaction.annotation.Transactional;

public interface PlaygroundService {
    @Transactional
    Playground register(Playground playGround);

    Long delete(Playground playGround);
}
