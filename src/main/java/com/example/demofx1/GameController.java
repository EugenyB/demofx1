package com.example.demofx1;

import com.example.demofx1.model.SnakeGame;
import com.example.demofx1.view.GameView;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameController {

    @FXML
    private Pane pane;
    @FXML
    private Canvas canvas;

    private SnakeGame game;
    private GameView view;

    public void initialize() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(evt -> view.draw());
        canvas.heightProperty().addListener(evt -> view.draw());

        game = new SnakeGame();
        view = new GameView(game, canvas);

        // TODO create and start timer
        pane.requestFocus();
    }

    public void processKey(KeyEvent keyEvent) {

    }
}