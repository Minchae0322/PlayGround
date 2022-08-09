package com.example.playground.serviceimpl;

import com.example.playground.pojo.playgroundpojo.Playground;
import com.example.playground.repository.PlaygroundRepository;
import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundServiceImpl implements PlaygroundService {
    private PlaygroundRepository playgroundRepository;

    @Autowired
    public PlaygroundServiceImpl(PlaygroundRepository playgroundRepository) {
        this.playgroundRepository = playgroundRepository;
    }

    @Override
    public Playground register(Playground playGround) {
        validateDuplicatePlayground(playGround.getName());
        playgroundRepository.save(playGround);
        return playGround;
    }

    @Override
    public Long delete(Playground playGround) {
        playgroundRepository.findPlaygroundById(playGround.getId())
               .ifPresent(p -> {
                   playgroundRepository.delete(playGround);
                });
        return playGround.getId();
    }

    private void validateDuplicatePlayground(String name) {
        playgroundRepository.findPlaygroundByName(name)
                .ifPresent(p -> {
                    throw new IllegalArgumentException("이미 존재하는 운동장 입니다.");
                });
    }


}
