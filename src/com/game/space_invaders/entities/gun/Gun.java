package com.game.space_invaders.entities.gun;


import com.game.space_invaders.costants.EntitiesImages;
import com.game.space_invaders.costants.EntitiesInitialPoints;
import com.game.space_invaders.entities.bullet.Bullet;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Gun {
    private final Image gunImage;
    private Point2D gunPoint;
    private Bullet bullet;

    public Gun() {
        this.gunImage = EntitiesImages.GUN_IMAGE.getEntityImage();
        this.gunPoint = EntitiesInitialPoints.GUN_INIT_POINT.getEntityPoint();
    }

    public Image getGunImage() {
        return this.gunImage;
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
        this.bullet = new Bullet();
        return this.bullet;
    }

    public void fireBullet() {
        if (this.bullet == null) return;

        this.bullet.setFired();
        this.bullet = null;
    }
}
