package com.autonomous.car;

public class Utility {
    static Direction getDirection(char dir) {
        switch (dir) {
            case 'N' -> {
                return Direction.N;
            }
            case 'E' -> {
                return Direction.E;
            }
            case 'S' -> {
                return Direction.S;
            }
            case 'W' -> {
                return Direction.W;
            }
        }
        throw new RuntimeException("Direction (" + dir + ") is Invalid");
    }

    static Direction getDirection(String dir) {
        if(dir.length() == 1)
            return getDirection(dir.charAt(0));

        switch (dir) {
            case "NORTH" -> {
                return Direction.N;
            }
            case "EAST" -> {
                return Direction.E;
            }
            case "SOUTH" -> {
                return Direction.S;
            }
            case "WEST" -> {
                return Direction.W;
            }
        }
        throw new RuntimeException("Direction (" + dir + ") is Invalid");
    }

    static Move getMove(char move) {
        switch (move) {
            case 'F' -> {
                return Move.F;
            }
            case 'L' -> {
                return Move.L;
            }
            case 'R' -> {
                return Move.R;
            }
        }
        throw new RuntimeException("Move (" + move + ") is Invalid");
    }
}
