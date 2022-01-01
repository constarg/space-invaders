package com.game.space_invaders.costants;

import java.awt.*;

public enum EntitiesInitialPoints {
    GUN_INIT_POINT(new Point(500,500)), // TODO - Find the right location.
    INVADER_1_INIT_POINT(new Point(800, 0)), // TODO - Find the right location.
    INVADER_2_INIT_POINT(new Point(450, 0)), // TODO - Find the right location.
    INVADER_3_INIT_POINT(new Point(50, 0)), // TODO - Find the right location.
    INVADER_4_INIT_POINT(new Point(250, 0)), // TODO - Find the right location.
    INVADER_5_INIT_POINT(new Point(650, 0)); // TODO - Find the right location.

    private final Point entityPoint;
    EntitiesInitialPoints(Point entityPoint) {
        this.entityPoint = entityPoint;
    }

    public Point getEntityPoint() {
        return this.entityPoint;
    }
}
