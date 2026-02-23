package ru.oivt.rectanglecli.model;

public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double perimeter() {
        return 2 * (a + b);
    }

    public double area() {
        return a * b;
    }

    public double diagonal() {
        return Math.sqrt(a * a + b * b);
    }

    public double inscribedCircleRadius() {
        return Math.min(a, b) / 2;
    }
}