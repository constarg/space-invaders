package com.game.space_invaders.entities.invaders;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;


public class Invader {
    private final Image invaderImage;
    private Point2D invaderPoint;

    public Invader(Image invaderImage, Point2D invaderPoint) {
        this.invaderImage = invaderImage;
        this.invaderPoint = invaderPoint;
    }

    public Image getInvaderImage() {
        return this.invaderImage;
    }

    public Point2D getInvaderPoint() {
        return this.invaderPoint;
    }

    public void moveInvaderDown() {
        this.invaderPoint = new Point2D(
                this.invaderPoint.getX(),
                this.invaderPoint.getY() + 2
        );
    }
}
