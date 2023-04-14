package com.example.demofx1.view;

import com.example.demofx1.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class GameView {

    public final static int CELL_SIZE = 15;

    private final SnakeGame game;
    private final Canvas canvas;

    public GameView(SnakeGame game, Canvas canvas) {
        this.game = game;
        this.canvas = canvas;
    }

    public void draw() {
        clear();
        drawField();
        drawSnake();
        drawApple();
    }

    private void drawApple() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Apple apple = game.getApple();
        drawElement(apple, gc, getScale(), Color.GREEN);
    }

    private void drawSnake() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Snake snake = game.getSnake();
        double scale = getScale();

        drawElement(snake.getHead(), gc, scale, Color.RED);

        for (SnakeElement element : game.getSnake().getBody()) {
            drawElement(element, gc, scale, Color.BLUE);
        }
    }

    private double getScale() {
        double size = Math.min(canvas.getWidth(), canvas.getHeight());
        return CELL_SIZE * SnakeGame.SIZE_XY / size;
    }

    private void drawElement(Element element, GraphicsContext gc, double scale, Color color) {
        gc.setFill(color);
        gc.fillOval(element.getX() * CELL_SIZE / scale, element.getY() * CELL_SIZE / scale, CELL_SIZE / scale, CELL_SIZE / scale);

    }

    private void drawField() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.GRAY);
        double size = Math.min(canvas.getWidth(), canvas.getHeight());
        double scale = CELL_SIZE * SnakeGame.SIZE_XY / size;
        for (int i = 0; i < SnakeGame.SIZE_XY; i++) {
            gc.strokeLine(0, i * CELL_SIZE / scale, size, i * CELL_SIZE / scale);
            gc.strokeLine(i * CELL_SIZE / scale, 0, i * CELL_SIZE / scale, size);
        }
        gc.strokeRect(0, 0, size, size);
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
