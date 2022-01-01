package com.game.space_invaders.costants;

import javafx.scene.image.Image;

public enum EntitiesImages {
    INVADER_1_IMAGE(new Image("../assets/invaders/invader_1.png")),
    INVADER_2_IMAGE(new Image("../assets/invaders/invader_2.png")),
    INVADER_3_IMAGE(new Image("../assets/invaders/invader_3.png")),
    GUN_IMAGE(new Image("../assets/invaders/gun.png"));

    private final Image entityImage;
    EntitiesImages(Image entityImage) {
        this.entityImage = entityImage;
    }

    public Image getEntityImage() {
        return entityImage;
    }
}
