package com.example.demofx1.model;

import java.util.LinkedList;
import java.util.List;

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

    public Element move() {
        body.addFirst(head);
        head = direction.next(head);
        return body.removeLast();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public SnakeElement getHead() {
        return head;
    }

    public List<SnakeElement> getBody() {
        return body;
    }

    public boolean isOut() {
        return head.getX() < 0 || head.getY() < 0 || head.getX() >= SnakeGame.SIZE_XY || head.getY() >= SnakeGame.SIZE_XY;
    }

    public boolean isEatItself() {
        return body.stream().anyMatch(e -> e.equals(head));
    }

    public boolean eat(Apple apple) {
        return head.getX() == apple.getX() && head.getY() == apple.getY();
    }

    public void grow(Element e) {
        body.addLast((SnakeElement) e);
    }
}
