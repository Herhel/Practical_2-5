package com.alfa.work5;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public void run() {
//        Shape[] collection = new Shape[10];
//        enterShape(collection);
        Shape[] collection = createShapes();
        collection = enterShape(collection);
        printShapes(collection);
    }

    private Shape[] createShapes() {
        return new Shape[]{Shape.parseShape("Rectangle:RED:10,20"),
                Shape.parseShape("Circle:BLACK:10"),
                Shape.parseShape("Triangle:GREEN:9,7,12")};
    }

    private Shape[] enterShape(Shape[] collection) {
        System.out.println("Введите фигуру в формате Shape:color:dimension1,...,dimensionN");
        Scanner sc = new Scanner(System.in);
        collection = addShape(collection, sc.next());
        return collection;
    }

    private Shape[] addShape(Shape[] collection, String params) {
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == null) {
                Shape temp = Shape.parseShape(params);
                if (temp != null) {
                    collection[i] = temp;
                }
                return collection;
            }
        }
        int index = collection.length;
        collection = Arrays.copyOf(collection, (int) (collection.length * 1.5));
        Shape temp = Shape.parseShape(params);
        if (temp != null) {
            collection[index] = temp;
        }
        return collection;
    }

    public void printShapes(Shape[] shapes) {
        System.out.println("\nФигуры в коллекции:");
        if (shapes != null && shapes.length > 0) {
            for (Shape shape : shapes) {
                if (shape != null) {
                    shape.draw();
                }
            }
        } else {
            System.out.println("Нет элементов для вывода");
        }
    }
}
