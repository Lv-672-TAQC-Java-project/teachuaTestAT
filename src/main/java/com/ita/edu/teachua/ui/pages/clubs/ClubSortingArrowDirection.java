package com.ita.edu.teachua.ui.pages.clubs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClubSortingArrowDirection {
    UP("//span[@aria-label='arrow-up']"),
    DOWN("//span[@aria-label='arrow-down']");

    private final String clubSortingArrowDirectionPath;
}
