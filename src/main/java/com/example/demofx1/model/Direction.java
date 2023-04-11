package com.example.demofx1.model;

@FunctionalInterface
public interface Direction {

    Direction UP = e -> new SnakeElement(e.getX(), e.getY() - 1);
    Direction DOWN = e -> new SnakeElement(e.getX(), e.getY() + 1);
    Direction LEFT = e -> new SnakeElement(e.getX() - 1, e.getY());
    Direction RIGHT = e -> new SnakeElement(e.getX() + 1, e.getY());

    SnakeElement next(SnakeElement element);
}
