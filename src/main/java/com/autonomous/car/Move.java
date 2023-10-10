package com.autonomous.car;
import lombok.Getter;

@Getter
public enum Move {
    F("FORWARD"),
    L("LEFT"),
    R("RIGHT");

    private final String string;

    Move(String string) {
        this.string = string;
    }

    Move getDirection(char dir) {
        if( dir == 'F') return F;
        if( dir == 'L') return L;
        if( dir == 'R') return R;
        else return F;
    }

    Move getDirection(String dir) {
        if( dir.equals(F.string)) return F;
        if( dir.equals(L.string)) return L;
        if( dir.equals(R.string)) return R;
        else return F;
    }

}
