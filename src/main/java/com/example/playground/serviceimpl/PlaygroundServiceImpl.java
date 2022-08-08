package com.example.playground.serviceimpl;

import com.example.playground.pojo.PlayGround;
import com.example.playground.repository.PlayGroundRepository;
import com.example.playground.service.PlayGroundService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlaygroundServiceImpl implements PlayGroundService {
    private PlayGroundRepository playGroundRepository;

    @Autowired
    public PlaygroundServiceImpl(PlayGroundRepository playGroundRepository) {
        this.playGroundRepository = playGroundRepository;
    }

    @Override
    public List<PlayGround> getPlaygroundList(String location) {
        return playGroundRepository.findPlayGroundsByLocation(location);
    }
}
