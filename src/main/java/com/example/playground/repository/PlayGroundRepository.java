package com.example.playground.repository;

import com.example.playground.pojo.PlayGround;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayGroundRepository extends JpaRepository<PlayGround, Long> {
    List<PlayGround> findPlayGroundsByLocation(String location);
}
