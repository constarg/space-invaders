package com.game.space_invaders.entities.gun;

import com.game.space_invaders.costants.DimensionConstants;
import com.game.space_invaders.costants.EntitiesImages;
import com.game.space_invaders.costants.EntitiesInitialPoints;
import com.game.space_invaders.entities.bullet.Bullet;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Gun {
    private Point2D gunPoint;
    private final ImageView gunImageView;

    public Gun() throws IOException {
        InputStream imageInputStream = new FileInputStream(
                EntitiesImages.GUN_IMAGE.getEntityImagePath()
        );
        Image gunImage = new Image(imageInputStream);
        this.gunImageView = new ImageView();
        this.gunImageView.setImage(gunImage);
        this.gunPoint = EntitiesInitialPoints.GUN_INIT_POINT.getEntityPoint();
    }

    public void initializeImage() {
        gunImageView.setX(this.gunPoint.getX());
        gunImageView.setX(this.gunPoint.getY());
        gunImageView.setFitWidth(
                DimensionConstants.GUN_DIMENSION.getEntityDimension().getWidth()
        );
        gunImageView.setFitHeight(
                DimensionConstants.GUN_DIMENSION.getEntityDimension().getHeight()
        );
        gunImageView.setPreserveRatio(true);
    }

    public ImageView getGunImageView() {
        return this.gunImageView;
    }

    public Point2D getGunPoint() {
        return this.gunPoint;
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
