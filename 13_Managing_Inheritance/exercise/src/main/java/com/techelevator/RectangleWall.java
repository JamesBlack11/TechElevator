package com.techelevator;

public class RectangleWall extends Wall {
    int length;

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    int height;


    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }
    public RectangleWall(String name, String color) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    public String toString()
    {
        return getName() + " " + "(" + (getLength() + "x" + getHeight()) + ")" + " rectangle" ;
    }

    @Override
    public int getArea() {
        return getHeight() * getLength();
    }
}

