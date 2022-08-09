package com.example.playground.serviceimpl;

import com.example.playground.pojo.playground.Playground;
import com.example.playground.repository.PlaygroundRepository;
import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundServiceImpl implements PlaygroundService {
    private PlaygroundRepository playGroundRepository;

    @Autowired
    public PlaygroundServiceImpl(PlaygroundRepository playGroundRepository) {
        this.playGroundRepository = playGroundRepository;
    }

    @Override
    public Playground register(Playground playGround) {
        validateDuplicatePlayground(playGround.getName());
        playGroundRepository.save(playGround);
        return playGround;
    }

    @Override
    public Long delete(Playground playGround) {
        playGroundRepository.findPlaygroundById(playGround.getId())
                .ifPresent(p -> {
                    playGroundRepository.delete(playGround);
                });
        return playGround.getId();
    }

    private void validateDuplicatePlayground(String name) {
        playGroundRepository.findPlaygroundByName(name)
                .ifPresent(p -> {
                    throw new IllegalArgumentException("이미 존재하는 운동장 입니다.");
                });
    }


}
