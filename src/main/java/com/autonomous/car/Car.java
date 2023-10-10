package com.autonomous.car;
import java.awt.Point;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private String name;
    private Point point;
    private Direction direction;
    private String command;

    private boolean isCarCollided = false;
    private int step = 0;

    Car() {

    }
    Car(String name, Point pos, Direction dir) {
        this.point = pos;
        this.direction = dir;
    }

    Car(String name, int x, int y, String s){
        this.point = new Point(x,y);
        this.direction = Utility.getDirection(s);
    }

    Car(String name, int x, int y, char s){
        this.point = new Point(x,y);
        this.direction = Utility.getDirection(s);
    }

    Car(String name, Point point, char dir){
        this.point = point;
        this.direction = Utility.getDirection(dir);
    }

    boolean moveCar(int commandIdx) {
        if( isCarCollided || commandIdx >= command.length()) return false;

        //System.out.println("idx = " + commandIdx + " cmd = " + command.charAt(commandIdx));
        Move move = Utility.getMove(command.charAt(commandIdx));
        switch (direction){
            case N -> {
                switch (move)
                {
                    case F -> {
                        moveNorth();
                    }
                    case L -> {
                        moveWest();
                    }
                    case R -> {
                        moveEast();
                    }
                }

            }
            case E -> {
                switch (move)
                {
                    case F -> {
                        moveEast();
                    }
                    case L -> {
                        moveNorth();
                    }
                    case R -> {
                        moveSouth();
                    }
                }
            }
            case S -> {
                switch (move)
                {
                    case F -> {
                        moveSouth();
                    }
                    case L -> {
                        moveEast();
                    }
                    case R -> {
                        moveWest();
                    }
                }
            }
            case W -> {
                switch (move)
                {
                    case F -> {
                        moveWest();
                    }
                    case L -> {
                        moveSouth();
                    }
                    case R -> {
                        moveNorth();
                    }
                }
            }
        }

        System.out.println("(" + point.x +" , " + point.y + ")");
        return true;
    }

    void moveEast() {
        if (Field.getInstance().isValidPosition(point.x + 1, point.y)) {
            ++point.x;
            ++step;
            direction = Direction.E;
        }
    }

    void moveWest() {
        if (Field.getInstance().isValidPosition(point.x - 1, point.y)) {
            --point.x;
            ++step;
            direction = Direction.W;
        }
    }

    void moveNorth() {
        if (Field.getInstance().isValidPosition(point.x , point.y + 1)) {
            ++point.y;
            ++step;
            direction = Direction.N;
        }
    }

    void moveSouth() {
        if (Field.getInstance().isValidPosition(point.x , point.y - 1)) {
            --point.y;
            ++step;
            direction = Direction.S;
        }
    }
}
