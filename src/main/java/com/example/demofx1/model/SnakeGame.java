package com.example.demofx1.model;

import java.util.Random;

public class SnakeGame {

    public final static int SIZE_XY = 50;

    private boolean running = true;

    private Random random = new Random();

    private Snake snake;

    private Apple apple;

    public SnakeGame() {
        snake = new Snake(5);
        newApple(snake);
    }

    private void newApple(Snake snake) {
        do {
            apple = new Apple(random.nextInt(SIZE_XY), random.nextInt(SIZE_XY));
        } while (snake.contains(apple));
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public Snake getSnake() {
        return snake;
    }

    public void tick() {
        if (running) {
            snake.move();
        }
    }

    public Apple getApple() {
        return apple;
    }

    public void turnSnake(Direction direction) {
        snake.setDirection(direction);
    }
}
