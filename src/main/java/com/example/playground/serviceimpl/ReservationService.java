package com.example.playground.serviceimpl;

import com.example.playground.pojo.Member;
import com.example.playground.pojo.PlayGround;
import com.example.playground.pojo.Reservation;
import com.example.playground.pojo.Team;
import com.example.playground.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class ReservationService implements com.example.playground.service.ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> reserveMember(Member member, PlayGround playGround, Date start, Date end) {
        if(isOverlapTime(member,start, end) && )
        reservation.ifPresent(r -> {
            if (isOverlapTime(r, start, end)) {
                reservationRepository.save(Reservation.builder()
                        .member(member)
                        .date(start)
                        .expiredDate(end)
                        .build());
            }});
        return Optional.empty();
    }

    @Override
    public Optional<Reservation> reserveTeam(Team team, Date start, Date end) {
        return Optional.empty();
    }

    private boolean isOverlapTime(Member member, Date start, Date end) {
        Optional<Reservation> reservation = reservationRepository.findReservationByMemberId(member.getId());
        if(reservation.isEmpty()) {
            return true;
        } else {
            return !reservation.get().getDate().after(start) && !reservation.get().getDate().before(end);
        }
    }
}