package com.example.demofx1;

import com.example.demofx1.model.Direction;
import com.example.demofx1.model.SnakeGame;
import com.example.demofx1.view.GameView;
import com.example.demofx1.view.View;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameController {

    @FXML
    private Label score;
    @FXML
    private Pane pane;
    @FXML
    private Canvas canvas;

    private SnakeGame game;

    public void initialize() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        game = new SnakeGame();
        View view = new GameView(game, canvas);
        View scoreView = new ScoreView(game, score);
        game.registerView(view);
        game.registerView(scoreView);

        canvas.widthProperty().addListener(evt -> view.update());
        canvas.heightProperty().addListener(evt -> view.update());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> processTick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        pane.requestFocus();
    }

    public void processTick() {
        game.tick();
    }

    public void processKey(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        System.out.println(keyCode);
        switch (keyCode) {
            case UP -> game.turnSnake(Direction.UP);
            case DOWN -> game.turnSnake(Direction.DOWN);
            case LEFT -> game.turnSnake(Direction.LEFT);
            case RIGHT -> game.turnSnake(Direction.RIGHT);
        }
    }
}