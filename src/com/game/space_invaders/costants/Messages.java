package com.game.space_invaders.costants;

public enum Messages {
    GAME_TITLE("Space Invaders");


    private final String message;
    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
