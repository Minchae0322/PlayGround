package com.example.playground.service;

import com.example.playground.pojo.PlayGround;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PlayGroundService {
    @Transactional
    List<PlayGround> getPlaygroundList(String location);
}
