package com.leanh;

public class Floor {
    private double width;
    private double length;

    public Floor(double width, double length) {
        if (width < 0 && length < 0) {
            this.width = 0;
            this.length = 0;
        } else if (width < 0) {
            this.width = 0;
            this.length = length;
        } else if (length < 0) {
            this.width = width;
            this.length = 0;
        } else {
            this.width = width;
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }
}
