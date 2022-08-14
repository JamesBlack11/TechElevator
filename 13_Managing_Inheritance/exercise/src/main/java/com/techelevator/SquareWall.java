package com.techelevator;

public class SquareWall extends RectangleWall {

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);
        this.sideLength = sideLength;

    }


    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public int sideLength;

    public String toString() {
        return getName() + " " + "(" + (getSideLength() + "x" + getSideLength()) + ")" + " square";
    }
    @Override
    public int getArea() {
        return getSideLength() * getSideLength();
    }
}

