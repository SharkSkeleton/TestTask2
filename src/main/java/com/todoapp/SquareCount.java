package com.todoapp;

public class SquareCount {

    public double square(double a) { return a*a; }

    public double circleSquare(double r) { return 3.14*square(r); }

    public double triangleSquare(double a, double h) { return 0.5*a*h; }

    public double rectangleSquare(double a, double b) { return a*b; }

    public double parallelogramSquare(double a, double h) { return a*h; }

    public double trapezeSquare(double a, double b, double h) { return 0.5*(a+b)*h; }

    public double ellipseSquare(double a, double b) { return 3.14*a*b; }
}
