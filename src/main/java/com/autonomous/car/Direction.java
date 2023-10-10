package com.autonomous.car;
import lombok.Getter;

@Getter
public enum Direction {
    N("NORTH"),
    E("EAST"),
    S("SOUTH"),
    W("WEST");

    private final String string;

    Direction(String string) {
        this.string = string;
    }

    Direction getDirection(char dir) {
        if( dir == 'N') return N;
        if( dir == 'E') return E;
        if( dir == 'S') return S;
        if( dir == 'W') return W;
        else return N;
    }

    Direction getDirection(String dir) {
        if( dir.equals(N.string)) return N;
        if( dir.equals(E.string)) return E;
        if( dir.equals(S.string)) return S;
        if( dir.equals(W.string)) return W;
        else return N;
    }

}
