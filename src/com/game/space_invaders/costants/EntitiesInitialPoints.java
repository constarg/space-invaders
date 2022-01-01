package com.game.space_invaders.costants;

import javafx.geometry.Point2D;

public enum EntitiesInitialPoints {
    GUN_INIT_POINT(new Point2D(0,0)), // TODO - Find the right location.
    INVADER_1_INIT_POINT(new Point2D(0, 0)), // TODO - Find the right location.
    INVADER_2_INIT_POINT(new Point2D(0, 0)), // TODO - Find the right location.
    INVADER_3_INIT_POINT(new Point2D(0, 0)); // TODO - Find the right location.

    private final Point2D entityPoint;
    EntitiesInitialPoints(Point2D entityPoint) {
        this.entityPoint = entityPoint;
    }

    public Point2D getEntityPoint() {
        return this.entityPoint;
    }
}
