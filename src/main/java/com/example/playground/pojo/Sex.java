package com.example.playground.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sex {
    MAN("MAN"), WOMAN("WOMAN");
    private final String value;
}
