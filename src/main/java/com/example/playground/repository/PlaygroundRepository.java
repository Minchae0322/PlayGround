package com.example.playground.repository;

import com.example.playground.pojo.playgroundpojo.Playground;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaygroundRepository extends JpaRepository<Playground, Long> {
    List<Playground> findPlaygroundsByLocation(String location);
    Optional<Playground> findPlaygroundById(Long id);
    Optional<Playground> findPlaygroundByName(String name);
}
