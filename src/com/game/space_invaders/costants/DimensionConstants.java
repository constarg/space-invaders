package com.game.space_invaders.costants;

import java.awt.*;

public enum DimensionConstants {
    BULLET_DIMENSION(new Dimension(0,0)), // TODO - Set right dimensions.
    MAIN_WINDOW_DIMENSION(new Dimension(950, 600)),
    GUN_DIMENSION(new Dimension(70, 70)),
    INVADERS_DIMENSION(new Dimension(90, 90));

    private final Dimension entityDimension;
    DimensionConstants(Dimension entityDimension) {
        this.entityDimension = entityDimension;
    }

    public Dimension getEntityDimension() {
        return this.entityDimension;
    }
}
