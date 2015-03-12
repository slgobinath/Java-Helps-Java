package com.javahelps.shapes;

import java.util.Random;

public class ShapeFactory {
    private Random random = new Random();
    public enum Type {
        CIRCLE, SQUARE, RECTANGLE;
    }

    public Shape createShape(Type type) {
        Shape shape = null;
        switch (type) {
        case CIRCLE:
            shape = new Circle(random.nextInt());
            break;
        case SQUARE:
            shape = new Square(random.nextInt());
            break;
        case RECTANGLE:
            shape = new Rectangle(random.nextInt(), random.nextInt());
        }
        return shape;
    }
}