package com.game.space_invaders.costants;

import javafx.scene.paint.Color;

public enum GameColors {
    BACKGROUND_COLOR(Color.BLACK);

    private final Color color;
    GameColors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
