package com.example.demofx1.view;

import com.example.demofx1.model.SnakeGame;
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
    }

    private void drawField() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.GREEN);
        double size = Math.min(canvas.getWidth(), canvas.getHeight());
        double scale = CELL_SIZE * SnakeGame.SIZE_XY / size;
        for (int i = 0; i < SnakeGame.SIZE_XY; i++) {
            gc.strokeLine(0, i * CELL_SIZE / scale, size, i * CELL_SIZE / scale);
            gc.strokeLine(i * CELL_SIZE / scale, 0, i * CELL_SIZE / scale, size);
        }
    }

    private void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
