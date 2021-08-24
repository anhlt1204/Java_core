package com.leanh;

public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double distance (int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public double distance (Point anotherPoint) {
        return Math.sqrt((this.x - anotherPoint.x) * (this.x - anotherPoint.x) +
                (this.y - anotherPoint.y) * (this.y - anotherPoint.y));
    }
}
