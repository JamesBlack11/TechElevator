
    package com.techelevator;

    public class TriangleWall extends Wall{
        private int height;
        private int base;


        public TriangleWall(String name, String color, int base, int height) {
            super(name, color);
            this.height = height;
            this.base = base;
        }

        public String toString() {
            return getName() + " ("+ base + "x" + height + ") " + "triangle";
        }
        public int getHeight() {
            return height;
        }
        public int getBase() {
            return base;
        }
        @Override
        public int getArea() {
            return (base * height) / 2;
        }
    }

