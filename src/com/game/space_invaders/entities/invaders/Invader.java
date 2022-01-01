package com.game.space_invaders.entities.invaders;


import com.game.space_invaders.costants.DimensionConstants;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Invader {
    private final ImageView invaderImageView;
    private Point2D invaderPoint;

    public Invader(String invaderImagePath, Point2D invaderPoint) throws IOException {
        InputStream imageStream = new FileInputStream(invaderImagePath);
        Image invaderImage = new Image(imageStream);
        invaderImageView = new ImageView();
        invaderImageView.setImage(invaderImage);
        this.invaderPoint = invaderPoint;
    }

    public void initializeImage() {
        this.invaderImageView.setX(this.invaderPoint.getX());
        this.invaderImageView.setX(this.invaderPoint.getY());
        this.invaderImageView.setFitWidth(
                DimensionConstants.INVADERS_DIMENSION.getEntityDimension().getWidth()
        );
        this.invaderImageView.setFitHeight(
                DimensionConstants.INVADERS_DIMENSION.getEntityDimension().getHeight()
        );
        this.invaderImageView.setPreserveRatio(true);
    }

    public ImageView getInvaderImageView() {
        return this.invaderImageView;
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
