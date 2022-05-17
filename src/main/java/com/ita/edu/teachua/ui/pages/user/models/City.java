package com.ita.edu.teachua.ui.pages.user.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum City {
    KYIV("Київ"),
    DNIPRO("Дніпро"),
    ODESA("Одеса"),
    LVIV("Львів"),
    RIVNE("Рівне"),
    LUTSK("Луцьк");

    private final String name;
}
