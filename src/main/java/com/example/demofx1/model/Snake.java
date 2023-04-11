package com.example.demofx1.model;

import java.util.LinkedList;

public class Snake {

    private LinkedList<SnakeElement> body;

    private SnakeElement head;

    private Direction direction;

    public Snake(int initialLength) {
        head = new SnakeElement(SnakeGame.SIZE_XY / 2, SnakeGame.SIZE_XY / 2);
        body = new LinkedList<>();
        for (int i = 1; i < initialLength; i++) {
            body.add(new SnakeElement(SnakeGame.SIZE_XY / 2, SnakeGame.SIZE_XY / 2 + i));
        }
        direction = Direction.UP;
    }

    public boolean contains(Apple apple) {
        // TODO do check apple in snake
        return false;
    }

    public void move() {
        body.addFirst(head);
        head = direction.next(head);
        // TODO check if apple was eaten
        body.removeLast();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
