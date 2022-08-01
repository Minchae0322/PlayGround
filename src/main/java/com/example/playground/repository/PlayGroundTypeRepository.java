package com.example.playground.repository;

import com.example.playground.pojo.PlayGround;
import com.example.playground.pojo.PlayGroundType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayGroundTypeRepository extends JpaRepository<PlayGroundType, Long> {
    Optional<PlayGroundType> findPlayGroundTypeByName(String name);
}
