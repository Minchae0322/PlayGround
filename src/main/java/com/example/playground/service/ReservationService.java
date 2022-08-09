package com.example.playground.service;

import com.example.playground.pojo.Member;
import com.example.playground.pojo.playgroundpojo.Playground;
import com.example.playground.pojo.Reservation;
import com.example.playground.pojo.Team;

import java.util.Date;
import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> reserveMember(Member member, Playground playGround, Date start, Date end);
    Optional<Reservation> reserveTeam(Team team, Date start, Date end);
}
