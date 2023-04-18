package com.example.demofx1.model;

import com.example.demofx1.view.View;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame {

    public final static int SIZE_XY = 50;

    private boolean running = true;

    private Random random = new Random();

    private Snake snake;

    private Apple apple;

    private List<View> views = new ArrayList<>();

    public SnakeGame() {
        snake = new Snake(5);
        newApple();
    }

    private void newApple() {
        do {
            apple = new Apple(random.nextInt(SIZE_XY), random.nextInt(SIZE_XY));
        } while (snakeContains(apple));
    }

    private boolean snakeContains(Apple apple) {
        if (snake.eat(apple)) return true;
        return snake.getBody().stream().anyMatch(e -> e.getX() == apple.getX() && e.getY() == apple.getY());
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
            Element e = snake.move();
            if (snake.eat(apple)) {
                snake.grow(e);
                newApple();
            }
            if (snake.isOut() || snake.isEatItself()) {
                running = false;
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game over!");
                alert.setTitle("Snake game");
                alert.setHeaderText(null);
                alert.show();
            }
            views.forEach(View::update);
        }
    }

    public Apple getApple() {
        return apple;
    }

    public void turnSnake(Direction direction) {
        snake.setDirection(direction);
    }

    public void registerView(View view) {
        views.add(view);
    }
}
