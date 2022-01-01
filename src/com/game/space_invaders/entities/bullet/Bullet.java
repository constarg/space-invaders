package com.game.space_invaders.entities.bullet;

import com.game.space_invaders.costants.DimensionConstants;
import com.game.space_invaders.costants.GameColors;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Bullet {
    private final Rectangle bulletShape;
    private Boolean fired;
    private Point bulletPoint;
    private Boolean isHit;

    public Bullet(Point bulletPoint) {
        this.bulletShape = new Rectangle(
                DimensionConstants.BULLET_DIMENSION.getEntityDimension().getWidth(),
                DimensionConstants.BULLET_DIMENSION.getEntityDimension().getHeight()
        );
        this.bulletShape.setFill(GameColors.BULLET_COLOR.getColor());
        this.bulletPoint = bulletPoint;
        this.bulletShape.setX(this.bulletPoint.getX());
        this.bulletShape.setY(this.bulletPoint.getY());
        this.fired = false;
        this.isHit = false;
    }

    public Rectangle getBulletShape() {
        return this.bulletShape;
    }

    public Point getBulletPoint() {
        return this.bulletPoint;
    }

    public Boolean isFired() {
        return this.fired;
    }

    public void setFired() {
        this.fired = true;
    }

    public void moveBullet() {
        int dy = 3;
        int dx = 0;
        this.bulletShape.setX(
                bulletPoint.getX() + dx
        );
        this.bulletShape.setY(
                bulletPoint.getY() - dy
        );

        this.bulletPoint = new Point(
                (int) (bulletPoint.getX() + dx),
                (int) (bulletPoint.getY() - dy)
        );
    }

    public void setIsHit(Boolean isHit) {
        this.isHit = isHit;
    }

    public Boolean getIsHit() {
        return this.isHit;
    }
}
