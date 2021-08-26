package com.alfa.work5;

public class Circle extends Shape {
    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", radius=" + radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        System.out.printf(this + ", area=%.2f \n", calcArea());
    }

    public static Circle parseCircle(String params) {
        String[] shapeParams = params.split(":");
        try {
            return new Circle(shapeParams[1], Integer.parseInt(shapeParams[2]));
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат данных размера окружности " + params);
            return null;
        }
    }

}
