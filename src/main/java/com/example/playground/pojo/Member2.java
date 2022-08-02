package com.example.playground.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Member2")
public class Member2 {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
