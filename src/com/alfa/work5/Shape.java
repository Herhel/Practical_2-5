package com.alfa.work5;

public abstract class Shape implements Drawable, Comparable, Cloneable {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "class=" + getClass().getSimpleName() +
                ", color=" + color;
    }

    public abstract double calcArea ();

    @Override
    public int compareTo(Object o) {
        if (this.calcArea() > ((Shape)o).calcArea()) return 1;
        if (this.calcArea() < ((Shape)o).calcArea()) return -1;
        return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
            return super.clone();
    }

    public static Shape parseShape (String params) {
        String[] shapeParams = params.split(":");
        if (shapeParams.length == 3) {
            if (shapeParams[0].equalsIgnoreCase("Circle")) {
                return Circle.parseCircle(params);
            }
            if (shapeParams[0].equalsIgnoreCase("Rectangle")) {
                return Rectangle.parseRectangle(params);
            }
            if (shapeParams[0].equalsIgnoreCase("Triangle")) {
                return Triangle.parseTriangle(params);
            }
            System.out.println("Не найдена фигура данного типа");
        } else {
            System.out.println("Введены не все данные или формат ввода неверный для фигуры " + params + "." +"\nДанные должны быть в формате Shape:color:dimension1,...,dimensionN");
        }
        return null;
    }
}
