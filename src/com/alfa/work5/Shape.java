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
        if (shapeParams[0].equalsIgnoreCase("Circle")){
            return new Circle(shapeParams[1], Integer.parseInt(shapeParams[2]));
        }
        if (shapeParams[0].equalsIgnoreCase("Rectangle")){
            String[] shapeDimensions = shapeParams[2].split(",");
            return new Rectangle(shapeParams[1], Integer.parseInt(shapeDimensions[0]),
                    Integer.parseInt(shapeDimensions[1]));
        }
        if (shapeParams[0].equalsIgnoreCase("Triangle")){
            String[] shapeDimensions = shapeParams[2].split(",");
            return new Triangle(shapeParams[1], Integer.parseInt(shapeDimensions[0]),
                    Integer.parseInt(shapeDimensions[1]), Integer.parseInt(shapeDimensions[2]));
        }
        System.out.println("Не найдена фигура данного типа");
        return null;
    }
}
