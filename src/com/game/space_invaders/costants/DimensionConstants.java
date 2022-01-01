package com.game.space_invaders.costants;

import javafx.geometry.Dimension2D;

public enum DimensionConstants {
    BULLET_DIMENSION(new Dimension2D(0,0)), // TODO - Set right dimensions.
    MAIN_WINDOW_DIMENSION(new Dimension2D(500, 500));

    private final Dimension2D entityDimension;
    DimensionConstants(Dimension2D entityDimension) {
        this.entityDimension = entityDimension;
    }

    public Dimension2D getEntityDimension() {
        return this.entityDimension;
    }
}
