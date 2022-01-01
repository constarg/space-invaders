package com.game.space_invaders.entities.gun;


import com.game.space_invaders.costants.DimensionConstants;
import com.game.space_invaders.costants.EntitiesImages;
import com.game.space_invaders.costants.EntitiesInitialPoints;
import com.game.space_invaders.entities.bullet.Bullet;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Gun {
    private final Image gunImage;
    private final Dimension2D gunDimensions;
    private Point2D gunPoint;
    InputStream imageInputStream;

    public Gun() throws IOException {
        this.imageInputStream = new FileInputStream(
                EntitiesImages.GUN_IMAGE.getEntityImagePath()
        );
        gunDimensions = new Dimension2D(
                DimensionConstants.GUN_DIMENSION.getEntityDimension().getWidth(),
                DimensionConstants.GUN_DIMENSION.getEntityDimension().getHeight()
        );
        this.gunImage = new Image(imageInputStream);
        this.gunPoint = EntitiesInitialPoints.GUN_INIT_POINT.getEntityPoint();
    }

    public Image getGunImage() {
        return this.gunImage;
    }

    public Point2D getGunPoint() {
        return this.gunPoint;
    }

    public Dimension2D getGunDimensions() {
        return this.gunDimensions;
    }

    public void moveGunRight() {
        this.gunPoint = new Point2D(
                this.gunPoint.getX() + 2,
                this.gunPoint.getY()
        );
    }

    public void moveGunLeft() {
        this.gunPoint = new Point2D(
                this.gunPoint.getX() - 2,
                this.gunPoint.getY()
        );
    }

    public Bullet prepareBullet() {
        return new Bullet();
    }
}
