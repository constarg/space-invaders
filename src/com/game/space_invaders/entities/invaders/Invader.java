package com.game.space_invaders.entities.invaders;


import com.game.space_invaders.costants.DimensionConstants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class Invader {
    private final ImageView invaderImageView;
    private Point invaderPoint;

    public Invader(String invaderImagePath, Point invaderPoint) throws IOException {
        InputStream imageStream = new FileInputStream(invaderImagePath);
        Image invaderImage = new Image(imageStream);
        invaderImageView = new ImageView();
        invaderImageView.setImage(invaderImage);
        this.invaderPoint = invaderPoint;
    }

    public void initializeImage() {
        this.invaderImageView.setX(this.invaderPoint.getX());
        this.invaderImageView.setY(this.invaderPoint.getY());
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

    public Point getInvaderPoint() {
        return this.invaderPoint;
    }

    public void moveInvaderDown() {
        this.invaderPoint = new Point(
                (int) this.invaderPoint.getX(),
                (int) (this.invaderPoint.getY() + 1)
        );
    }
}
