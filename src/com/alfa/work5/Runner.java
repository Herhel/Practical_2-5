package com.alfa.work5;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public void run() {
        Shape[] collection = enterShapeCollection();
        printShapes(collection);
    }

    private Shape[] enterShapeCollection() {
        Shape[] collection;
        System.out.println("Введите размер коллекции:");
        Scanner sc = new Scanner(System.in);
        int arraySize;
        while (true) {
            if (sc.hasNextInt()) {
                arraySize = sc.nextInt();
                if (arraySize > 0) {
                    collection = new Shape[arraySize];
                    break;
                }
            }
            System.out.println("Вы ввели значение не подходящее для размера коллекции! Введите целое число больше чем 0");
            sc.nextLine();
        }
        for (int i = 0; i < collection.length; i++) {
            while (true) {
                System.out.println("Введите фигуру в формате Shape:color:dimension1,...,dimensionN");
                Shape temp = Shape.parseShape(sc.next());
                if (temp != null) {
                    addShape(collection, temp);
                    System.out.println("Фигура добавлена в коллекцию");
                    break;
                }
            }
        }
        return collection;
    }

//    private Shape[] createShapes() {
//        return new Shape[]{Shape.parseShape("Rectangle:RED:10,20"),
//                Shape.parseShape("Circle:BLACK:10"),
//                Shape.parseShape("Triangle:GREEN:9,7,12")};
//    }

    private Shape[] addShape(Shape[] collection, Shape shape) {
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] == null) {
                collection[i] = shape;
                return collection;
            }
        }
        int index = collection.length;
        collection = Arrays.copyOf(collection, (int) (collection.length * 1.5));
        collection[index] = shape;
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
            System.out.println("\nНет элементов для вывода");
        }
    }
}
