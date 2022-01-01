package com.game.space_invaders.utils;

import com.game.space_invaders.costants.EntitiesImages;
import com.game.space_invaders.costants.EntitiesInitialPoints;
import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.gun.Gun;
import com.game.space_invaders.entities.invaders.Invader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class GameRefresh {
    static Timeline refreshTimeline;
    static Timeline generateTimeline;
    static private HashSet<Invader> invaders = null;
    static private ArrayList<Bullet> bullets;

    private static void GenerateInvaders(Group group) throws IOException {
        if (invaders == null) invaders = new HashSet<Invader>();

        // Generate invader.
        Invader invader_1 = new Invader(
                EntitiesImages.INVADER_1_IMAGE.getEntityImagePath(),
                EntitiesInitialPoints.INVADER_1_INIT_POINT.getEntityPoint()
        );
        Invader invader_2 = new Invader(
                EntitiesImages.INVADER_2_IMAGE.getEntityImagePath(),
                EntitiesInitialPoints.INVADER_2_INIT_POINT.getEntityPoint()
        );
        Invader invader_3 = new Invader(
                EntitiesImages.INVADER_3_IMAGE.getEntityImagePath(),
                EntitiesInitialPoints.INVADER_3_INIT_POINT.getEntityPoint()
        );
        // Initialize image for each invader.
        invader_1.initializeImage();
        invader_2.initializeImage();
        invader_3.initializeImage();
        // Add invaders to hashset.
        invaders.add(invader_1);
        invaders.add(invader_2);
        invaders.add(invader_3);
        // Add the images on the group.
        group.getChildren().add(invader_1.getInvaderImageView());
        group.getChildren().add(invader_2.getInvaderImageView());
        group.getChildren().add(invader_3.getInvaderImageView());
    }

    private static void refreshBullets() {

    }

    private static void refreshInvaders(Group ) {

    }

    private static void refreshGun() {

    }

    public static void gunFiresBullet(Gun gun, Group group) {
        Bullet tmpBullet = gun.prepareBullet();
        bullets.add(tmpBullet);
        group.getChildren().add(tmpBullet.getBulletShape());
    }

    public static void refreshGame(Group group, Gun gun) {
        // initialize bullet array.
        bullets = new ArrayList<>();
        // init gun image.
        gun.initializeImage();
        group.getChildren().add(gun.getGunImageView());

        GameRefresh.generateTimeline = new Timeline(new KeyFrame(Duration.seconds(2), t -> {
            /*try {
                GameRefresh.GenerateInvaders(group);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }));

        GameRefresh.refreshTimeline = new Timeline(new KeyFrame(Duration.millis(10), t -> {
        }));

        GameRefresh.refreshTimeline.setCycleCount(Timeline.INDEFINITE);
        GameRefresh.generateTimeline.setCycleCount(Timeline.INDEFINITE);
        GameRefresh.refreshTimeline.play();
        GameRefresh.generateTimeline.play();
    }
}
