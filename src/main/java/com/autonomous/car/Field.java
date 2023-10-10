package com.autonomous.car;
import java.awt.Point;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    private int width;
    private int height;

    private Field() {
    }

    public static Field instance;
    public static Field getInstance()
    {
        if( instance == null)
            instance = new Field();

        return  instance;
    }

    boolean isValidPosition(int x, int y)
    {
        boolean invalidPosition =  x < 0 || y < 0 || x >= width || y >= height;
        return !invalidPosition;
    }
}