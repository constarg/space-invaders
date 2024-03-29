package com.game.space_invaders.utils;

import com.game.space_invaders.costants.DimensionConstants;
import com.game.space_invaders.costants.EntitiesImages;
import com.game.space_invaders.costants.EntitiesInitialPoints;
import com.game.space_invaders.entities.bullet.Bullet;
import com.game.space_invaders.entities.gun.Gun;
import com.game.space_invaders.entities.invaders.Invader;
import com.game.space_invaders.event.impl.InvaderKilledEvent;
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
    static Timeline invadersDownTimeline;
    static final private HashSet<Invader> invaders = new HashSet<>();
    static final private ArrayList<Bullet> bullets = new ArrayList<>();

    private static void generateInvaders(Group group) throws IOException {
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
        Invader invader_4 = new Invader(
                EntitiesImages.INVADER_1_IMAGE.getEntityImagePath(),
                EntitiesInitialPoints.INVADER_4_INIT_POINT.getEntityPoint()
        );
        Invader invader_5 = new Invader(
                EntitiesImages.INVADER_3_IMAGE.getEntityImagePath(),
                EntitiesInitialPoints.INVADER_5_INIT_POINT.getEntityPoint()
        );
        // Initialize image for each invader.
        invader_1.initializeImage();
        invader_2.initializeImage();
        invader_3.initializeImage();
        invader_4.initializeImage();
        invader_5.initializeImage();
        // Add invaders to hashset.
        invaders.add(invader_1);
        invaders.add(invader_2);
        invaders.add(invader_3);
        invaders.add(invader_4);
        invaders.add(invader_5);
        // Add the images on the group.
        group.getChildren().add(invader_1.getInvaderImageView());
        group.getChildren().add(invader_2.getInvaderImageView());
        group.getChildren().add(invader_3.getInvaderImageView());
        group.getChildren().add(invader_4.getInvaderImageView());
        group.getChildren().add(invader_5.getInvaderImageView());
    }

    private static void bulletHitInvader(Bullet bullet) {
        GameRefresh.invaders.forEach(invader -> {
            double distance = invader.getInvaderPoint().distance(
                    bullet.getBulletPoint().getX(),
                    bullet.getBulletPoint().getY());

            if (distance <= 70.0 && !invader.getIsKilled()) {
                new InvaderKilledEvent().emit(
                        invader,
                        bullet
                );
            }

        });
    }

    private static void refreshBullets(Group group) {
        for (Bullet bullet: bullets) {
            if (bullet.getIsHit()) {
                group.getChildren().remove(bullet.getBulletShape());
                GameRefresh.bullets.remove(bullet);
                return;
            }
            if (bullet.isFired()) {
                if (!group.getChildren().contains(bullet.getBulletShape()))
                    group.getChildren().add(bullet.getBulletShape());
                bullet.moveBullet();
                bulletHitInvader(bullet);

                if (bullet.getBulletPoint().getY() <= 0) {
                    GameRefresh.bullets.remove(bullet);
                    group.getChildren().remove(bullet.getBulletShape());
                }
            }
        }
    }

    private static void refreshInvaders(Group group) {
        for (Invader invader: invaders) {
            if (invader.getIsKilled()) {
                group.getChildren().remove(invader.getInvaderImageView());
                GameRefresh.invaders.remove(invader);
                return;
            }
            invader.moveInvaderDown();
            invader.getInvaderImageView().setY(
                    invader.getInvaderPoint().getY()
            );
        }
    }

    private static void refreshGun(Gun gun) {
        gun.getGunImageView().setX(
                gun.getGunPoint().getX()
        );
        gun.getGunImageView().setY(
                gun.getGunPoint().getY()
        );
    }

    private static void invaderReachBottom() {
        for (Invader invader: invaders) {
            if (invader.getInvaderPoint().getY() >=
                    DimensionConstants.MAIN_WINDOW_DIMENSION.getEntityDimension().getHeight()) {
                GameRefresh.refreshTimeline.stop();
                GameRefresh.generateTimeline.stop();
                GameRefresh.invadersDownTimeline.stop();
            }
        }
    }

    public static void gunFiresBullet(Gun gun, Group group) {
        Bullet tmpBullet = gun.prepareBullet();
        tmpBullet.setFired();
        GameRefresh.bullets.add(tmpBullet);
        group.getChildren().add(tmpBullet.getBulletShape());
    }

    public static void refreshGame(Group group, Gun gun) {
        // init gun image.
        gun.initializeImage();
        group.getChildren().add(gun.getGunImageView());
        // First invade.
        try {
            GameRefresh.generateInvaders(group);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameRefresh.generateTimeline = new Timeline(new KeyFrame(Duration.seconds(3), t -> {
            try {
                GameRefresh.generateInvaders(group);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        GameRefresh.invadersDownTimeline = new Timeline(new KeyFrame(Duration.millis(30), t -> {
            refreshInvaders(group);
        }));

        GameRefresh.refreshTimeline = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            refreshGun(gun);
            refreshBullets(group);
            invaderReachBottom();
        }));

        GameRefresh.refreshTimeline.setCycleCount(Timeline.INDEFINITE);
        GameRefresh.generateTimeline.setCycleCount(Timeline.INDEFINITE);
        GameRefresh.invadersDownTimeline.setCycleCount(Timeline.INDEFINITE);
        GameRefresh.refreshTimeline.play();
        GameRefresh.generateTimeline.play();
        GameRefresh.invadersDownTimeline.play();
    }
}
