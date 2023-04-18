package com.example.demofx1;

import com.example.demofx1.model.SnakeGame;
import com.example.demofx1.view.View;
import javafx.scene.control.Label;

public class ScoreView implements View {

    private SnakeGame game;
    private Label score;

    public ScoreView(SnakeGame game, Label score) {
        this.game = game;
        this.score = score;
    }

    @Override
    public void update() {
        int size = game.getSnake().getBody().size();
        score.setText("Length = " + (size + 1));
    }
}
