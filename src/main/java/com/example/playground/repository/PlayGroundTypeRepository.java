package com.example.playground.repository;

import com.example.playground.pojo.PlayGround;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayGroundTypeRepository extends JpaRepository<PlayGround, String> {
}
