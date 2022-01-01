package com.game.space_invaders.costants;

import javafx.scene.image.Image;

public enum EntitiesImages {
    INVADER_1_IMAGE("src/com/game/space_invaders/assets/invaders/invader_1.png"),
    INVADER_2_IMAGE("src/com/game/space_invaders/assets/invaders/invader_2.png"),
    INVADER_3_IMAGE("src/com/game/space_invaders/assets/invaders/invader_3.png"),
    GUN_IMAGE("src/com/game/space_invaders/assets/gun/gun.png");

    private final String entityImage;
    EntitiesImages(String entityImage) {
        this.entityImage = entityImage;
    }

    public String getEntityImagePath() {
        return entityImage;
    }
}
