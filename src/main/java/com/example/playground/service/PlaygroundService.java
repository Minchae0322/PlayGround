package com.example.playground.service;

import com.example.playground.pojo.playgroundpojo.Playground;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface PlaygroundService {
    Playground register(Playground playGround);

    Long delete(Playground playGround);
}
