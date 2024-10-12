package org.knit.lab2;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double getVolume();
}

class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends Shape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
}

class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

class Container {
    private double capacity;
    private double availableVolume;
    private List<Shape> shapes;

    public Container(double capacity) {
        this.capacity = capacity;
        this.availableVolume = capacity;
        this.shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= availableVolume) {
            shapes.add(shape);
            availableVolume -= shapeVolume;
            System.out.println("Фигура добавлена. Остаток объема: " + availableVolume);
        } else {
            System.out.println("Невозможно добавить фигуру. Недостаточно места.");
        }
    }

    public double getAvailableVolume() {
        return availableVolume;
    }

    public double getTotalVolume() {
        return capacity;
    }
}

public class Task4 {
    public static void main(String[] args) {
        Container container = new Container(1000);

        Shape sphere = new Sphere(5);
        Shape cube = new Cube(3);
        Shape cylinder = new Cylinder(3, 7);

        container.add(sphere);
        container.add(cube);
        container.add(cylinder);
    }
}
